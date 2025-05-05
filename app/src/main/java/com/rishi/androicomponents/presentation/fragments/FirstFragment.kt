package com.rishi.androicomponents.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rishi.androicomponents.R


class FirstFragment : Fragment() {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("lion22", "FirstFragment - onAttach: line no 18 ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("lion22", "FirstFragment - onDestroy: line no 30")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("lion22", "FirstFragment - onDetach: line no 35")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lion22", "FirstFragment - onResume: line no 41")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lion22", "FirstFragment - onPause: line no 46")
    }
    override fun onStop() {
        super.onStop()
        Log.d("lion22", "FirstFragment - onStop: line no 50")
    }

}