package com.example.apt_java_project.daili

class Agent(val message: Message) : Message {

    private fun before() {
        println("一条路服务")
    }

    private fun after() {
        println("满意度调查")
    }

    override fun message(str:String) {
        before()
//        message.message()
        after()
    }
}