package com.example.apt_java_project.asm.kotlin.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


//TODO  提供委托(provideDelegate)
//
class StringDelegateUpdate(var str: String = "Default") : ReadWriteProperty<Owner2, String> {
    override fun getValue(thisRef: Owner2, property: KProperty<*>): String {
        println("getValue执行啦")
        return str
    }

    override fun setValue(thisRef: Owner2, property: KProperty<*>, value: String) {
        println("setValue执行啦")
        str = value
    }
}


//提供者委托
class SmartDelegator {
    //相当于一个选择器,动态选择 是那个自定义委托
    operator fun provideDelegate(
        thisRef: Owner2,
        property: KProperty<*>
    ): ReadWriteProperty<Owner2, String> {
        return if (property.name.contains("log")) {
            StringDelegateUpdate("normal")
        } else {
            StringDelegateUpdate("log")
        }
    }
}

class Owner2 {
    var normalText: String by SmartDelegator()
    var logText: String by SmartDelegator()
}

fun main() {
    val owner = Owner2()
    println(owner.logText)
    println(owner.normalText)
}