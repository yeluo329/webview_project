package com.example.apt_java_project.asm.kotlin.lambda

fun main() {

    fun t01() {
        println(1)
    } //默认unit,除非指定类型

    fun t02() {
        44.0f
    }    //默认unit,除非指定类型

    fun t03(): String {
        return "1"
    } // String

    fun s01(): () -> Unit = {} // 返回类型:()->Unit   函数返回一个函数
    fun s02(): () -> Unit = { println("123") }
    s02()()

    val method: () -> Unit = { println("123") }
    fun s03(): Unit = run(method)
    fun s04(): Boolean = run { false }
    fun s05(): () -> Boolean = { true }
    println(s05()())
    show { println(it) }




}

fun show(block: (Int) -> Unit) {
    return block(2)
}