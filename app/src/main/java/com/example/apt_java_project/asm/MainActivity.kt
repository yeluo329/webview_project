package com.example.apt_java_project.asm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apt_java_project.R

import kotlin.reflect.KProperty
import kotlin.reflect.jvm.javaField

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.tv)
        val btn: Button = findViewById(R.id.btn)
//        var message: String? by textView
//        Log.d("ljz", "MainActivity:${message}")
//        btn.setOnClickListener { message = "ljz修改布局" }

        val item = Item()
        Log.d("ljz", item.version22)
        item.version22 = "11"
        Log.d("ljz", item.version22)
//        val mainViewModel: MainViewModel by viewModels()
//        println(mainViewModel.value)
//        mainViewModel.value = "ljz"
//        println(mainViewModel.value)

        //官方提供了 viewModels
    }


}


//private fun MainActivity.viewModels(): ReadOnlyProperty<MainActivity?, MainViewModel> =
//    object : ReadOnlyProperty<MainActivity?, MainViewModel> {
//        override fun getValue(thisRef: MainActivity?, property: KProperty<*>): MainViewModel {
//            return ViewModelProvider(this@viewModels).get(MainViewModel::class.java)
//        }
//    }


// 扩展函数
//class MyTest(private var textView: TextView) {
//    operator fun provideDelegate(
//        thisRef: Any?,
//        property: KProperty<*>
//    ): ReadWriteProperty<Nothing?, String?> {
//        return Simple(textView)
//    }
//}

class Item {
    var version11: String = "123"
    var version22: String by version11

}

operator fun String.getValue(thisRef: Item, property: KProperty<*>) = this + "ljz"

//property 委托类  thisRef:调用
operator fun String.setValue(thisRef: Item, property: KProperty<*>, value: String) {

    Log.d("ljz", "setValue:$value")
    property.javaField
    for (field in property.javaClass.declaredFields) {
        Log.d("ljz", field.name)
    }
//    try {
//        val cls: Class<*> = thisRef.javaClass
//        for (field in cls.declaredFields) {
//            if (field.name.contains("version22")) {
//                field.isAccessible = true
//                field.set(thisRef, value)
//            }
//        }
//    } catch (e: Exception) {
//        Log.e("ljz", e.message.toString())
//        e.printStackTrace()
//    }

}

//operator fun TextView.provideDelegate(
//    thisRef: Any?,
//    property: KProperty<*>
//): ReadWriteProperty<Any?, String?> {
//    return Simple(this)
//}
//
//
//class Simple(private var textView: TextView) : ReadWriteProperty<Any?, String?> {
//    override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
//        Log.d("ljz", "message getValue 调用${textView.text}")
//        return textView.text as String?
//    }
//
//    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
//        Log.d("ljz", "message:$value")
//        textView.text = value
//    }
//
//}


