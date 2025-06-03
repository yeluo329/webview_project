package com.example.apt_java_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apt_java_project.inject.InjectView
import com.example.apt_java_project.jump.Autowired
import java.nio.file.attribute.UserPrincipal

class MainActivity2 : AppCompatActivity() {

    @Autowired
    var name: String = "ljz"

    @Autowired("boy")
    var boy: Boolean = false


    @Autowired
    var array: IntArray = IntArray(0)

    @InjectView("123")
    private var tv: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        InjectUtil.injectView(this)
        setContentView(R.layout.activity_main2)

        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
                .putExtra("name", "ljz")
                .putExtra("attr", "帅")
                .putExtra("array", intArrayOf(1, 2, 3, 4, 5, 6))
                .putExtra("userParcelable", UserParcelable("ljz"))
                .putExtra("userParcelables", arrayOf(UserParcelable("haha")))
                .putExtra("strs", arrayOf("1", "2"))

            startActivity(intent)
        }
//        val parent: LinearLayout = findViewById(R.id.main)
//        parent.addView(tv)


    }
}