package com.rishi.androicomponents.presentation.shareDataUsingViewModel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.rishi.androicomponents.R

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        supportFragmentManager.beginTransaction()
            .replace(R.id.sharedFrameLayout, YourNameFragment()).commit()
    }
}