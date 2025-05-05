package com.rishi.androicomponents.presentation.shareDataBetweenFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rishi.androicomponents.R

/*
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
 */


class SeeYourNameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
         */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_see_your_name, container, false)
        val tv = view.findViewById<TextView>(R.id.tvActualName)
        //
        val a = arguments
//
        val yourName = a?.getString("yourName")
        tv.text = yourName
        /*
        better way
                arguments?.let {
                    tv.text = it.getString("yourName")
                }
                */
        return view
    }

    /*
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SeeYourNameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    */
}