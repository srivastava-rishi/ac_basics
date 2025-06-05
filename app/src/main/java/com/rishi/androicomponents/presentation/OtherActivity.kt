package com.rishi.androicomponents.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.rishi.androicomponents.R
import com.rishi.androicomponents.presentation.fragments.FirstFragment
import com.rishi.androicomponents.presentation.fragments.SecondFragment

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        Log.d("whatthefuck!!", "OtherActivity - onCreate: ")

        val f1 = FirstFragment()
        val f2 = SecondFragment()

        val btnOpenFragmentOne: Button = findViewById(R.id.btn_open_fragment_one)
        val btnOpenFragmentTwo: Button = findViewById(R.id.btn_open_fragment_two)
        val uniqieActivity: Button = findViewById(R.id.btn_open_uniquie_sctivity)

      //  supportFragmentManager.beginTransaction().replace(R.id.frameLayout,f2).commit()

        btnOpenFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, f1).commit()
        }
        btnOpenFragmentTwo.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.frameLayout, f2)
            ft.commit()
        }

        uniqieActivity.setOnClickListener {
            startActivity(Intent(this,UniqueActivity::class.java))
        }

    }


    override fun onStart() {
        super.onStart()
        Log.d("whatthefuck!!", "OtherActivity - onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("whatthefuck!!", "OtherActivity - onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("whatthefuck!!", "OtherActivity - onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("whatthefuck!!", "OtherActivity - onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("whatthefuck!!", "OtherActivity - onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("whatthefuck!!", "OtherActivity - onDestroy: ")
    }
}

/*


fun attachFragment(fragmentHolderLayoutId: Int, fragment: Fragment?, tag: String?) {
    val manager: FragmentManager = supportFragmentManager
    val ft: FragmentTransaction = manager.beginTransaction()

// supportFragmentManager.beginTransaction().add(R.id.framelayout,Fragment()).commit()
    //Hide other fragments
    for (frag in manager.fragments) {
        ft.hide(frag)
    }

    if (manager.findFragmentByTag(tag) == null) { // No fragment in backStack with same tag..
        ft.add(fragmentHolderLayoutId, fragment!!, tag)
        //ft.addToBackStack(tag)
        ft.commit()
    } else {
        //Shows the selected fragment.
        ft.show(manager.findFragmentByTag(tag)!!).commit()
    }

}

*/
