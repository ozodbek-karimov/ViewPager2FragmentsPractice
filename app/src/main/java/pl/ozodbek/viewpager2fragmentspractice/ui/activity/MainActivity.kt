package pl.ozodbek.viewpager2fragmentspractice.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import pl.ozodbek.viewpager2fragmentspractice.adapters.FragmentStateAdapter
import pl.ozodbek.viewpager2fragmentspractice.databinding.ActivityMainBinding
import pl.ozodbek.viewpager2fragmentspractice.ui.fragments.DailyPaymentsFragment
import pl.ozodbek.viewpager2fragmentspractice.ui.fragments.MonthlyPaymentsFragment
import pl.ozodbek.viewpager2fragmentspractice.ui.fragments.WeeklyPaymentsFragment
import pl.ozodbek.viewpager2fragmentspractice.utils.Constants.Companion.DAILY_PAYMENTS_FRAGMENT_NAME
import pl.ozodbek.viewpager2fragmentspractice.utils.Constants.Companion.MONTHLY_PAYMENTS_FRAGMENT_NAME
import pl.ozodbek.viewpager2fragmentspractice.utils.Constants.Companion.WEEKLY_PAYMENTS_FRAGMENT_NAME
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setupViewPager2()
    }

    private fun setupViewPager2() {
        val fragments = ArrayList<Fragment>()
        fragments.add(DailyPaymentsFragment())
        fragments.add(WeeklyPaymentsFragment())
        fragments.add(MonthlyPaymentsFragment())

        val titles = ArrayList<String>()
        titles.add(DAILY_PAYMENTS_FRAGMENT_NAME)
        titles.add(WEEKLY_PAYMENTS_FRAGMENT_NAME)
        titles.add(MONTHLY_PAYMENTS_FRAGMENT_NAME)


        val pagerAdapter = FragmentStateAdapter(
            Bundle(), fragments, this
        )

        binding.tabViewPager2.apply {
            adapter = pagerAdapter
        }


        TabLayoutMediator(binding.tablayout, binding.tabViewPager2) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}