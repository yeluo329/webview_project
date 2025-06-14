package com.example.apt_java_project.asm

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.util.Log


@Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
//空白的fragment
public open class LjzFragment : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("ljz","ljzFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ljz","ljzFragment onResume")
    }


    companion object {
        private const val LJZ_FRAGMENT_TAG =
            "lifecycle.LifecycleDispatcher.ljz_fragment_tag"

        @JvmStatic
        public fun injectLjzFragment(activity: Activity) {
            val manager = activity.fragmentManager
            if (manager.findFragmentByTag(LJZ_FRAGMENT_TAG) == null) {
                manager.beginTransaction().add(LjzFragment(), LJZ_FRAGMENT_TAG).commit()
                manager.executePendingTransactions()
            }
        }
    }
}