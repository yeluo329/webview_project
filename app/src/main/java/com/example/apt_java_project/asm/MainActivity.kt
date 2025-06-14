package com.example.apt_java_project.asm

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.apt_java_project.R

// 被观察者 lifecycleOwner
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LjzFragment.injectLjzFragment(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btn)


//        btn.setOnClickListener {
//            lifecycle.addObserver(MyObserver())
//        }
    }


}

