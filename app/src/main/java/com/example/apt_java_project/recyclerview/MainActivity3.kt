package com.example.apt_java_project.recyclerview

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apt_java_project.R

class MainActivity3 : AppCompatActivity() {
    var rv: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        rv = findViewById(R.id.rv)

        rv?.let {
            it.layoutManager = GridLayoutManager(this, 1)
            it.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        }


        val list: MutableList<String> = ArrayList()
        for (i in 0..999) {
            list.add("" + i)
        }

    }
}



