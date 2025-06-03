package com.example.apt_java_project

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apt_java_project.jump.Autowired
import com.example.apt_java_project.jump.JumpUtil

class MainActivity : AppCompatActivity() {

    @Autowired("name")
    var name: String = ""

    @Autowired
    var attr: String = ""

    @Autowired("array")
    var array: IntArray = intArrayOf()

    @Autowired
    var userParcelable: UserParcelable = UserParcelable("ljz")

    @Autowired
    var userParcelables: Array<UserParcelable> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JumpUtil.jump(this)
        setContentView(R.layout.activity_main)
        Toast.makeText(
            this,
            "name:$name,attr:$attr," +
                    "array第一个元素:${array[0]}", Toast.LENGTH_SHORT
        ).show()
    }
}