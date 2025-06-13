package com.example.apt_java_project.asm.kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    val group: LiveData<String> by ::myGroup

    private var myGroup: MutableLiveData<String> = MutableLiveData<String>()
}