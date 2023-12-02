package pl.ozodbek.viewpager2fragmentspractice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.ozodbek.viewpager2fragmentspractice.R
import pl.ozodbek.viewpager2fragmentspractice.adapters.DailyPaymentAdapter
import pl.ozodbek.viewpager2fragmentspractice.data.DailyPayments
import pl.ozodbek.viewpager2fragmentspractice.databinding.FragmentDailyPaymentsBinding
import pl.ozodbek.viewpager2fragmentspractice.databinding.FragmentMonthlyPaymentsBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class DailyPaymentsFragment : Fragment(R.layout.fragment_daily_payments) {

    private val binding by viewBinding(FragmentDailyPaymentsBinding::bind)
    private val dailyPaymentAdapter:DailyPaymentAdapter by lazy { DailyPaymentAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = dailyPaymentAdapter

        val dailyPayments: List<DailyPayments> = generateDummyData()

        dailyPaymentAdapter.submitList(dailyPayments)

    }

    private fun generateDummyData(): List<DailyPayments> {
        val dummyDataList = mutableListOf<DailyPayments>()

        for (i in 1..50) {
            val earning = generateRandomAmount()
            val distance = generateRandomDistance()
            val deliveries = generateRandomDeliveries()

            val dailyPayments = DailyPayments(earning, distance, deliveries)
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