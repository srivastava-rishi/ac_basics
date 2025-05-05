package com.rishi.androicomponents.presentation.shareDataBetweenFrag

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rishi.androicomponents.R

class ShareDataBetweenFragmentsUsingArguementsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_data_between_fragments_using_arguements)
        supportFragmentManager.beginTransaction().replace(R.id.framelayot,EnterYourNameFragment()).commit()
    }
}