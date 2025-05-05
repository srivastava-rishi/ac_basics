package com.rishi.androicomponents.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rishi.androicomponents.R


class SecondFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("lion22", "SecondFragment - onAttach: line no 17")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lion22", "SecondFragment - onDestroy: line no  30")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("lion22", "SecondFragment - onDetach: line no  35")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lion22", "SecondFragment - onResume: line no 40")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lion22", "SecondFragment - onPause: line no 45")
    }
    override fun onStop() {
        super.onStop()
        Log.d("lion22", "SecondFragment - onStop: line no 49")
    }
}