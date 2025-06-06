package com.example.sheji

import com.example.sheji.dynamic.PersonInvocationHandler
import java.lang.reflect.Proxy

class MyClass {
    fun test() {
        //静态代理
        val personImpl = PersonImpl()
//        val agent = Agent(personImpl)
//        agent.speak("雷")
//        agent.run()


        //动态代理
        val handler = PersonInvocationHandler(personImpl)
        val proxy =
            Proxy.newProxyInstance(
                personImpl.javaClass.classLoader,
                arrayOf(Person::class.java, Animal::class.java),
                handler
            )

        val person = proxy as Person
        person.speak("徐盼盼")
        person.run()

        val animal = proxy as Animal
        animal.shot()

    }
}

fun main() {
    val cls = MyClass()
    cls.test()
}