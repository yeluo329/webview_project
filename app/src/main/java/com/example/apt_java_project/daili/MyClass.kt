package com.example.apt_java_project.daili

import com.example.apt_java_project.aa
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class MyClass {
    fun main() {
        //静态代理
//        val message: Message = Ljz()
//        val agent = Agent(message)
//        agent.message()


        // 动态代理(一个代理类,实现全部接口)

        //真正的实现类
        val ljz = Ljz()

        //代理类
        val obj = Proxy.newProxyInstance(
            MyClass::class.java.classLoader, arrayOf(
                Wash::class.java,
                Message::class.java
            ), object : InvocationHandler {
                override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
                    return method.invoke(ljz, *(args ?: emptyArray()))
                }
            }
        )

        val message = obj as Message
        message.message("123")

        val wash = obj as Wash
        wash.wash()

    }
}

fun main() {

//    val a = aa()
//    a.test()

    val c = MyClass()
    c.main()
}
