package com.example.apt_java_project.daili

class Ljz : Message, Wash {
    override fun message(str: String) {
        println("$str,ljz服务你喔")
    }

    override fun wash() {
        println("帮你洗")
    }
}