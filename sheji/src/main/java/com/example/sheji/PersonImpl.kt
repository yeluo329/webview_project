package com.example.sheji

class PersonImpl : Person, Animal {
    override fun speak(name: String) {
        println("$name,在说话")
    }

    override fun run() {
        println("神在跑")
    }

    override fun shot() {
        println("我在叫")
    }
}