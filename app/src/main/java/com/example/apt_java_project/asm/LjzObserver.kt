package com.example.apt_java_project.asm

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class LjzObserver : LifecycleEventObserver {
    private val TAG = "ljz"
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_RESUME -> Log.d(TAG, "connect run")
            Lifecycle.Event.ON_PAUSE -> Log.d(TAG, "disconnect run")
            else -> {}
        }
    }
}