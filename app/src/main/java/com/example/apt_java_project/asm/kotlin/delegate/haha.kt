package com.example.apt_java_project.asm.kotlin.delegate

import android.content.res.Resources.Theme
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *  委托类  == 静态代理(模版）
 */
interface MyDB {
    fun save()
}


class LjzDb : MyDB {
    override fun save() {
        println("ljzDb进行存储")
    }
}


class XppDb : MyDB {
    override fun save() {
        println("XppDb进行存储")
    }
}

class Agent(db: MyDB) : MyDB by db


/**
 *   委托属性
 */
class MyClass {
    @Deprecated(
        "name is Deprecated,use NewNam",
        replaceWith = ReplaceWith("NewName")
    )
    var name: String by ::NewName

    var NewName: String = ""

    val responseData: String by lazy { requestDownLoad() }

    private fun requestDownLoad(): String {
        println("开始请求")
        Thread.sleep(2000)
        return "下载完成"
    }
}

class MyOwner {
    var gradeName by MyTest("数学")

    var bbb by ProvideDelegateTest()

    var aaa by ProvideDelegateTest()
}

/**
 *  自定义委托
 *
 */

class MyTest(private var default: String) : ReadWriteProperty<MyOwner, String> {

    override fun getValue(thisRef: MyOwner, property: KProperty<*>): String {
        return default
    }

    override fun setValue(thisRef: MyOwner, property: KProperty<*>, value: String) {
        default = value
    }
}

/**
 *  提供者委托
 */

class ProvideDelegateTest {
    operator fun provideDelegate(
        thisRef: MyOwner,
        property: KProperty<*>
    ): ReadWriteProperty<MyOwner, String> {
        return if (property.name == "bbb") {
            MyTest("aaa")
        } else {
            MyTest("bbb")
        }
    }
}


fun main() {
//    Agent(XppDb()).save()
//    Agent(LjzDb()).save()

    val cls = MyClass()
    val aa = cls.NewName

    //懒加载
//    println(cls.responseData)
//    println(cls.responseData)
//    println(cls.responseData)

    val owner = MyOwner()
    owner.gradeName = "语文"
    println(owner.bbb)
    println(owner.aaa)
    println(owner.gradeName)


}

