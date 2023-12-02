package pl.ozodbek.viewpager2fragmentspractice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.ozodbek.viewpager2fragmentspractice.R
import pl.ozodbek.viewpager2fragmentspractice.databinding.FragmentDailyPaymentsBinding
import pl.ozodbek.viewpager2fragmentspractice.databinding.FragmentMonthlyPaymentsBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class DailyPaymentsFragment : Fragment(R.layout.fragment_daily_payments) {

    private val binding by viewBinding(FragmentDailyPaymentsBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}