package com.vandr.playerview

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_player_view.view.*

class PlayerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var selectedColor = -1
    private var unSelectedColor = -1

    init {
        View.inflate(context, R.layout.activity_player_view, this)
        context.obtainStyledAttributes(
            attrs,
            R.styleable.PlayerView
        ).use {
            selectedColor = it.getColor(R.styleable.PlayerView_PV_selectedColor, -1)
            unSelectedColor = it.getColor(R.styleable.PlayerView_PV_unSelectedColor, -1)
            firstName.text = it.getText(R.styleable.PlayerView_PV_firstNamePlayer)
            secondName.text = it.getText(R.styleable.PlayerView_PV_secondNamePlayer)
            teamName.text = it.getText(R.styleable.PlayerView_PV_teamNamePlayer)
            number.text = it.getText(R.styleable.PlayerView_PV_numberPlayer)
            ivPlayer.setImageDrawable(it.getDrawable(R.styleable.PlayerView_PV_imgPlayer))
            root.setBackground(unSelectedColor)
        }
        setOnClickListener()
    }

    fun setTitle(nameFirst: String, nameSecond: String, team: String, num: String) {
        firstName.text = nameFirst
        secondName.text = nameSecond
        teamName.text = team
        number.text = num
    }

    private fun setOnClickListener() {
        ivPlayer.setOnClickListener {
            val color = if (isClickable) selectedColor else unSelectedColor
            root.setBackground(color)
        }
    }

    private fun View.setBackground(@ColorInt color: Int) {
        val drawable = background
        if (drawable is GradientDrawable) {
            drawable.apply {
                cornerRadius = resources.getDimension(R.dimen.dp20)
                setStroke(resources.getDimensionPixelSize(R.dimen.dp2), color)
            }
        }
    }
}