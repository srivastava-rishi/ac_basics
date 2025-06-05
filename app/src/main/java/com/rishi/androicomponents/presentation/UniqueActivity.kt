package com.rishi.androicomponents.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rishi.androicomponents.R

class UniqueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unique)
        Log.d("whatthefuck!!", "UniqueActivity - onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d("whatthefuck!!", "UniqueActivity - onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("whatthefuck!!", "UniqueActivity - onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("whatthefuck!!", "UniqueActivity - onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("whatthefuck!!", "UniqueActivity - onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("whatthefuck!!", "UniqueActivity - onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("whatthefuck!!", "UniqueActivity - onDestroy: ")
    }
}