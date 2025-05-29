package com.rishi.androicomponents.second

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishi.androicomponents.R
import com.rishi.androicomponents.third.ThirdActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btn = findViewById<Button>(R.id.btnScreenB)
        val openSecondActivityAgain = findViewById<Button>(R.id.btnScB)

        btn.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        openSecondActivityAgain.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("lion222", "onNewIntent: line no 34 ")
    }
}

//adb shell dumpsys activity activities | grep
// adb shell dumpsys activity activities | grep -A 30 com.rishi.androicomponents

