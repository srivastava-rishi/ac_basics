package com.rishi.androicomponents.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rishi.androicomponents.R
import com.rishi.androicomponents.home.viewmodel.HomeViewModel
import com.rishi.androicomponents.second.SecondActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        // init
        val viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_I
            startActivity(intent)
        }
    }
}