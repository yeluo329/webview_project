package com.example.apt_java_project.inject

import android.app.Activity
import android.graphics.Color
import android.widget.TextView

class InjectUtil {
    companion object {
        fun injectView(activity: Activity) {
            val cls: Class<out Activity> = activity.javaClass
            for (filed in cls.declaredFields) {
                if (filed.isAnnotationPresent(InjectView::class.java)) {
                    val annotations: InjectView? = filed.getAnnotation(InjectView::class.java)
                    annotations?.let {
                        val tv = TextView(activity)
                        tv.text = it.value
                        tv.setTextColor(Color.GREEN)
                        tv.textSize = 50F
                        filed.isAccessible = true
                        try {
                            filed.set(activity, tv)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
    }
}