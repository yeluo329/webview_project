package com.example.apt_java_project.asm

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

//观察者
class MyObserver : DefaultLifecycleObserver {
    private val TAG = "ljz"

    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "create 启动定位服务中...")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "start 连接系统定位服务...")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "resume 系统定位界面展示")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "pause 系统定位界面关闭")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "stop 断开系统定位服务")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "destroy 系统销毁中")
    }

}