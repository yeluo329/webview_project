package com.example.apt_java_project.asm.kotlin.delegate

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

interface qinfen<out T> {
    val value: T

}

operator fun <T> qinfen<T>.getValue(thisRef: Any?, property: KProperty<*>): T =
    value


class haha {
    var data by Delegates.observable(-1) { property, oldValue, newValue ->
        //监听 data 的变化
        println("oldValue = $oldValue newValue = $newValue")
    }
}