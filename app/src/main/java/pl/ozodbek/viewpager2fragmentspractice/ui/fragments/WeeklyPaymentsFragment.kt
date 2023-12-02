package pl.ozodbek.viewpager2fragmentspractice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.ozodbek.viewpager2fragmentspractice.R
import pl.ozodbek.viewpager2fragmentspractice.databinding.FragmentWeeklyPaymentsBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class WeeklyPaymentsFragment : Fragment(R.layout.fragment_weekly_payments) {

    private val binding by viewBinding(FragmentWeeklyPaymentsBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}