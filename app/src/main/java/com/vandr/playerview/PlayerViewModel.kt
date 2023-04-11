package com.vandr.playerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel  : ViewModel() {
    val namePlayer = MutableLiveData<List<Player>>()

    fun getPlayers() {
        namePlayer.value = listOf(
            Player("Микола", "Шапаренко", "ФК Динамо", "#10"),
            Player("Євген", "Коноплянка", "ФК Шахтар", "#30"),
            Player("Андрій", "П`ятов", "ФК Шахтар", "#1"),
            Player("Денис", "Безбородько", "ФК Десна", "#12")
        )
    }
}