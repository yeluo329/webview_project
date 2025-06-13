package com.example.apt_java_project.asm.kotlin.lambda


fun main() {

    // 函数的声明,用lambda去描述函数的声明
    //Kotlin Unit == Java Void
    val method1: () -> Unit
    val method2: (Int, Int) -> Unit
    val method3: (String, Double) -> Any

    //函数的声明+函数的实现
    val method01: () -> Unit = { println("我是method01函数") }
    method01()//调用函数
    method01.invoke()//调用函数

    val method02: () -> String = { "我是method02函数" }
    println(method02())

    val method03: (String) -> String = { str: String -> "$str,哈哈" }
    println(method03("哈哈"))

    val method04 = { a: Int, b: Int -> "${a}_${b}" }
    println(method04(1, 2))


    val method05: (Int) -> String = fun(a) = a.toString()
    val method06: (Int) -> String = { a -> "a的值:$a" }
    println(method06(1))
    //只有一个参数,不需要直接it代替
    val method07: (Int) -> String = { it.toString() }


    val method08: (String, String) -> Unit = { a, b -> println("a的值:${a},b的值:${b}") }


    val method9: String.() -> Unit = {
        //this == String 本身
        println("你是$this")
    }
    "DDD".method9()

    val method10: Int.(Int) -> String = { "两数相加的结果是${this + it}" }
    println(1.method10(2))

    fun Int.method10(a: Int): String {
        return "两数相加的结果是${this + a}"
    }

    "ljz".show()
}


fun String.show() {
    println("你是:$this")
}