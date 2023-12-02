package pl.ozodbek.viewpager2fragmentspractice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import pl.ozodbek.viewpager2fragmentspractice.R
import pl.ozodbek.viewpager2fragmentspractice.adapters.MonthlyPaymentAdapter
import pl.ozodbek.viewpager2fragmentspractice.data.MonthlyPayments
import pl.ozodbek.viewpager2fragmentspractice.databinding.FragmentMonthlyPaymentsBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class MonthlyPaymentsFragment : Fragment(R.layout.fragment_monthly_payments) {

    private val binding by viewBinding(FragmentMonthlyPaymentsBinding::bind)
    private val monthlyPaymentAdapter: MonthlyPaymentAdapter by lazy { MonthlyPaymentAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = monthlyPaymentAdapter

        val dailyPayments: List<MonthlyPayments> = generateDummyData()
        monthlyPaymentAdapter.submitList(dailyPayments)

    }

    private fun generateDummyData(): List<MonthlyPayments> {
        val dummyDataList = mutableListOf<MonthlyPayments>()

        for (i in 1..50) {
            val earning = generateRandomAmount()
            val distance = generateRandomDistance()
            val deliveries = generateRandomDeliveries()

            val dailyPayments = MonthlyPayments(earning, distance, deliveries)
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