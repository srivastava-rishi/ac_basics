package com.rishi.androicomponents.presentation.shareDataUsingViewModel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.rishi.androicomponents.R

class AgeFragment : Fragment() {

    private lateinit var onboardingViewModel: OnBoardingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_age, container, false)
        val et1 = view.findViewById<EditText>(R.id.your_age)
        val btn = view.findViewById<Button>(R.id.next_button_age)

        onboardingViewModel = ViewModelProvider(requireActivity())[OnBoardingViewModel::class.java]

        // navigate as well as save data to viewModel
        btn.setOnClickListener {
            onboardingViewModel.updateUiState(OnBoardingData.AGE, et1.text.toString())
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.sharedFrameLayout, FamilyFragment())
                ?.commit()
        }

        return view
    }
}