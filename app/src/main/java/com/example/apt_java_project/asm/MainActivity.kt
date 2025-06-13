package com.example.apt_java_project.asm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apt_java_project.R

class MainActivity : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.btn)

    }
}

