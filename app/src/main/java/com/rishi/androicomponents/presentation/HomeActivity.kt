package com.rishi.androicomponents.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.rishi.androicomponents.R


/*

Ways to Integrate fragment inside an Activity : -
1. <fragment tag - static fragment that will be always same
2. <frameLayout tag - or we can have a container on which we can add , replace or remove fragment fragment dynamically...
3. <fragmentContainerView

*/


// https://developer.android.com/guide/fragments/transactions

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btn: Button = findViewById(R.id.btn_open_other)
        btn.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }
    }
}