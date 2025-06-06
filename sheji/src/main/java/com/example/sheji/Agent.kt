package com.example.sheji

class Agent(private val person: Person) : Person {
    override fun speak(name: String) {
        println("说话之前")
        person.speak(name)
        println("说话之后")
    }

    override fun run() {
        person.run()
    }
}