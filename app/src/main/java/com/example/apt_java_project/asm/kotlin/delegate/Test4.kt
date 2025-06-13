package com.example.apt_java_project.asm.kotlin.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Owner {

    //get/set方法 第一个参数  必须包含 本类owner或owner父类
    var text: String by StringDelegate()
}

class StringDelegate : ReadWriteProperty<Owner, String> {
    private var str: String = "Default"
    override fun getValue(thisRef: Owner, property: KProperty<*>): String {
        println("getValue执行啦")
        return str
    }

    override fun setValue(thisRef: Owner, property: KProperty<*>, value: String) {
        println("setValue执行啦")
        str = value
    }

}

class Simple4 {
    private var str: String = "Default"
    operator fun getValue(owner: Owner, property: KProperty<*>): String {
        println("getValue执行啦")
        return str
    }

    operator fun setValue(owner: Owner, property: KProperty<*>, value: String) {
        println("setValue执行啦")
        str = value
    }
}

fun main() {
    val owner = Owner()
    owner.text = "ljz"
    println(owner.text)
}