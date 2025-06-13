package com.example.apt_java_project.asm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.apt_java_project.R
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity2 : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)
        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.btn)
        var message: String by MyTest(tv)

        btn.setOnClickListener { message = "ljz haha " }

    }


}

class MyTest(private var textView: TextView) {
    operator fun provideDelegate(
        thisRef: Any?,
        property: KProperty<*>
    ): ReadWriteProperty<Any?, String> {
        return object : ReadWriteProperty<Any?, String> {
            override fun getValue(thisRef: Any?, property: KProperty<*>): String {
                return textView.text as String
            }

            override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
                textView.text = value
            }

        }
    }
}
//operator fun TextView.operateProvide(
//    thisRef: Any?,
//    property: KProperty<*>
//): ReadWriteProperty<Any?, String> {
//    return object : ReadWriteProperty<Any?, String> {
//        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
//
//        }
//
//        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//
//        }
//
//    }
//
//}

//private fun MainActivity2.myViewModel(): ReadOnlyProperty<MainActivity2?, TestViewModel> =
//    object : ReadOnlyProperty<MainActivity2?, TestViewModel> {
//        override fun getValue(thisRef: MainActivity2?, property: KProperty<*>): TestViewModel {
//            return ViewModelProvider(this@myViewModel).get(TestViewModel::class.java)
//        }
//    }

