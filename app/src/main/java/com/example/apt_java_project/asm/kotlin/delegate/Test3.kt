package com.example.apt_java_project.asm.kotlin.delegate


fun requestDownLoad(): String {
    println("run")
    Thread.sleep(2000L)
    return "恭喜你 下载完成"
}

val responseData: String by lazy { requestDownLoad() }

fun main() {

    println("开始请求")
    //responseData如果没有值,只有在用responseData的时候,才会加载,这就是懒加载
    println(responseData)
    println(responseData)
    println(responseData)
}