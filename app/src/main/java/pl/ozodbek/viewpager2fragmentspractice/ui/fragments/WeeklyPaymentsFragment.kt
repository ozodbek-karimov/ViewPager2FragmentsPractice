package pl.ozodbek.viewpager2fragmentspractice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.ozodbek.viewpager2fragmentspractice.R
import pl.ozodbek.viewpager2fragmentspractice.adapters.WeeklyPaymentAdapter
import pl.ozodbek.viewpager2fragmentspractice.data.WeeklyPayments
import pl.ozodbek.viewpager2fragmentspractice.databinding.FragmentWeeklyPaymentsBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class WeeklyPaymentsFragment : Fragment(R.layout.fragment_weekly_payments) {

    private val binding by viewBinding(FragmentWeeklyPaymentsBinding::bind)
    private val weeklyPaymentAdapter: WeeklyPaymentAdapter by lazy { WeeklyPaymentAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = weeklyPaymentAdapter

        val dailyPayments: List<WeeklyPayments> = generateDummyData()
        weeklyPaymentAdapter.submitList(dailyPayments)

    }

    private fun generateDummyData(): List<WeeklyPayments> {
        val dummyDataList = mutableListOf<WeeklyPayments>()

        for (i in 1..50) {
            val earning = generateRandomAmount()
            val distance = generateRandomDistance()
            val deliveries = generateRandomDeliveries()

            val dailyPayments = WeeklyPayments(earning, distance, deliveries)
            dummyDataList.add(dailyPayments)
        }

        return dummyDataList
    }

    private fun generateRandomAmount(): Double {
        return (100 + (Math.random() * 900))
    }

    private fun generateRandomDistance(): Double {
        return (5 + (Math.random() * 20))
    }

    private fun generateRandomDeliveries(): String {
        return (1 + (Math.random() * 10)).toInt().toString()
    }
}