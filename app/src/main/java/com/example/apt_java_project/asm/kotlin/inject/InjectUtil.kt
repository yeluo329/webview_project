package com.example.apt_java_project.asm.kotlin.inject

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater

class InjectUtil {

    companion object {

        @SuppressLint("SoonBlockedPrivateApi")
        fun init(activity: Activity) {
            val field = LayoutInflater::class.java.getDeclaredField("mFactorySet")
            field.isAccessible = true
            field.setBoolean(activity.layoutInflater, false)
        }
    }
}