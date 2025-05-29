package com.rishi.androicomponents.third

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishi.androicomponents.R
import com.rishi.androicomponents.second.SecondActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val btn = findViewById<Button>(R.id.btnScreenC)

        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_I
            startActivity(intent)
        }
    }
}