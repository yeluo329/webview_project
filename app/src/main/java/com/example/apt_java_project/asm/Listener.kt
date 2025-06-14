package com.example.apt_java_project.asm

import android.util.Log

class Listener {
    val TAG = "ljz"

    fun onStart() {
        Log.d(TAG, "onStart调用")
    }

    fun onResume() {
        Log.d(TAG, "onResume调用")
    }

    fun onPause() {
        Log.d(TAG, "onPause调用")
    }

    fun onStop() {
        Log.d(TAG, "onStop调用 ")
    }
}