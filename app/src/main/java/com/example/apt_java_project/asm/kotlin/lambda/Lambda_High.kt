package com.example.apt_java_project.asm.kotlin.lambda

fun main() {

    // Function1<String,Int> 等价于  (String)->Int
    val method1: Function1<String, Int> = { str: String -> str.length }
    println(method1("23"))

    val method2: Function2<Boolean, String, Unit> =
        { isOk: Boolean, str: String -> println("isOk:$isOk,str:$str") }
    method2(false, "22")


    fun aa() {}
    val aa2 = {}
    //aa 是一个函数,是一个实打实函数
    //aa2 是接受一个匿名函数变量,变量可以执行匿名函数
    val aa3 = aa2
    val aa4 = ::aa//::含义 就是把这个实打实函数 变成 (函数引用) 所有可以赋值传递 给另外一个变量

    val method = fun(n1: Int, n2: Int): (Int, Int) -> String = { a, b ->
        "a+b的值 ${a + b},n1:$n1,n2:${n2}"
    }
    println(method(100, 200)(1000, 200))


}