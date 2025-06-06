package com.example.sheji.dynamic

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class PersonInvocationHandler(val target: Any) : InvocationHandler {
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
        println("方法调用前:${method.name}")
        val result = method.invoke(target, *(args ?: emptyArray()))
        println("方法调用后:${method.name}")
        return result
    }
}