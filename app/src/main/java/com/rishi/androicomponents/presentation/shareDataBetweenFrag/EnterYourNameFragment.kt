package com.rishi.androicomponents.presentation.shareDataBetweenFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.rishi.androicomponents.R


/*
// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
 */


class EnterYourNameFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_enter_your_name, container, false)

        val btnOpenFragmentOne: Button = view.findViewById(R.id.next_button)

// Prepare your Bundle
// Prepare your fragment SeeYourNameFragment
        btnOpenFragmentOne.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(
                "yourName",
                view.findViewById<EditText>(R.id.enter_your_name).text.toString()
            )
            val f2 = SeeYourNameFragment()
            f2.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.framelayot, f2)
                ?.commit()
        }
        return view
    }

    /*
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterYourNameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    */
}