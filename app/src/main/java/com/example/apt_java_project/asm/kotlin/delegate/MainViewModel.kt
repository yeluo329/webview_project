package com.example.apt_java_project.asm.kotlin.delegate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // 内部修改,外部只读
    private val _newsViewState = MutableLiveData<String>()
    val newsViewState: LiveData<String> by ::_newsViewState

    private val _weatherState = MutableLiveData<String>()
    val weatherState: LiveData<String> by ::_weatherState

    private val _imageOfTheDayState = MutableLiveData<String>()
    val imageOfTheDayState: LiveData<String> by ::_imageOfTheDayState

    var value = "MyName"

    fun getNews() {

    }

    fun getWeather() {

    }

    fun getImage() {


    }


}