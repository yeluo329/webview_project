package com.example.apt_java_project.asm.kotlin.delegate

/**
 *  委托属性
 */

class Simple {

    var floatValue: Float = 99.08f
        set(value) {
            println("你设置 floatValue:$value")
            field = value
        }
        get() {
            println("返回$field")
            return field
        }

    var number :Float by::floatValue


}