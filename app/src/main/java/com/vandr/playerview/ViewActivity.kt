package com.vandr.playerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity: AppCompatActivity(), BaseDialog.Listener {

    private val playerModel = PlayerViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        playerModel.getPlayers()

        playerModel.namePlayer.observe(this) {
            setTitlesAndActions(
                players = it, player1, player2, player3, player4
            )
        }
    }

    private fun setTitlesAndActions(players: List<Player>, vararg customViews: PlayerView) {
        customViews.forEachIndexed { index, customView ->
            val player = players.getOrElse(index) { Player("", "", "", "") }
            val firstName = player.firstName
            val secondName = player.secondName
            val teamName = player.teamName
            val numberPlayer = player.number
            customView.setTitle(firstName, secondName, teamName, numberPlayer)
            customView.setOnClickListener {
                val message =
                    "Гравець: ${player.firstName} ${player.secondName}\nКоманда: ${player.teamName}\nНомер: ${player.number}"
                BaseDialog.newInstance(message, supportFragmentManager)
            }
        }
    }

    override fun onClick() {
        Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
    }
}
