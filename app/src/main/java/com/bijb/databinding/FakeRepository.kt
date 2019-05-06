package com.bijb.databinding

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {
    private val fruitNames: List<String> = listOf(
            "Pisang",
            "Durian",
            "Semangka",
            "Alpukat",
            "Apel"
    )
    private val _currentRandom =  MutableLiveData<String>()
    val currentRandom: LiveData<String>
        get() = _currentRandom

    init {
        _currentRandom.value = fruitNames.first()
    }

    fun getRandomFruit(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeRandomFruit() {
        _currentRandom.value = getRandomFruit()
    }
}