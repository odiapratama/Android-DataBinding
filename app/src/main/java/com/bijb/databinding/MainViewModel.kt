package com.bijb.databinding

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Bindable

class MainViewModel: ViewModel() {
    val currentRandom: LiveData<String>
        get() = FakeRepository.currentRandom

    fun onChangeRandomFruitClick() = FakeRepository.changeRandomFruit()

    @Bindable
    val etContent = MutableLiveData<String>()


    private val _displayedETContent = MutableLiveData<String>()
    val displayedETContent: LiveData<String>
        get() = _displayedETContent

    fun onDisplayETContentClick() {
        _displayedETContent.value = etContent.value
    }

    fun onSelectRandomETFruit() {
        etContent.value = FakeRepository.getRandomFruit()
    }
}