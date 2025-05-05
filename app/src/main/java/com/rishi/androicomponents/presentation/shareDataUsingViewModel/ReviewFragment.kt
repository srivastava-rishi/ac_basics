package com.rishi.androicomponents.presentation.shareDataUsingViewModel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.rishi.androicomponents.R

class ReviewFragment : Fragment() {

    private lateinit var onboardingViewModel: OnBoardingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_review, container, false)
        onboardingViewModel = ViewModelProvider(requireActivity())[OnBoardingViewModel::class.java]

        val tv1 = view.findViewById<TextView>(R.id.tv_your_name_value)
        val tv2 = view.findViewById<TextView>(R.id.tv_your_age_value)
        val tv3 = view.findViewById<TextView>(R.id.tv_your_father_value)
        val tv4 = view.findViewById<TextView>(R.id.tv_your_mothers_value)

//        onboardingViewModel.uiState.observe(viewLifecycleOwner, {
//            tv1.text = it.name
//            tv2.text = it.age
//            tv3.text = it.fathersName
//            tv4.text = it.mothersName
//        })

        tv1.text = onboardingViewModel.uiState.value?.name
        tv2.text = onboardingViewModel.uiState.value?.age
        tv3.text = onboardingViewModel.uiState.value?.fathersName
        tv4.text = onboardingViewModel.uiState.value?.mothersName

        return view
    }
}