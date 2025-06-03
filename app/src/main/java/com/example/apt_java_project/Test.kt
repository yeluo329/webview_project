package com.example.apt_java_project

import androidx.annotation.IntDef

class Test {
    @IntDef(value = [SUNDAY, MONDAY])
    @Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
    @Retention(
        AnnotationRetention.SOURCE
    )
    annotation class WekDay

    companion object {
        const val SUNDAY: Int = 0
        const val MONDAY: Int = 1

        @WekDay
        var mCurrentDay: Int = 0

        fun setCurrentDay(@WekDay currentDay: Int) {
            mCurrentDay = currentDay
        }
    }

}
