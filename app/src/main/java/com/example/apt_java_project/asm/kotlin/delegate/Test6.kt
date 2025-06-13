package com.example.apt_java_project.asm.kotlin.delegate

class Model {
    //可以修改的集合
    //mutableListOf 可修改集合   List不可修改集合
    // val 修饰符的意义:是只读,但是现在可以修改,有问题

    val data: MutableList<String> = mutableListOf()

    fun load() {
        data.add("Hello")
    }
}

class Model2 {
    //TODO 需求:内部可以修改,但外部 只读

    val data: List<String> by ::_data

    private val _data: MutableList<String> = mutableListOf()

}

fun main() {
    val model = Model2()
    model.data

}