package pl.ozodbek.viewpager2fragmentspractice.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.ozodbek.viewpager2fragmentspractice.data.WeeklyPayments
import pl.ozodbek.viewpager2fragmentspractice.databinding.PaymentsRowItemBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class WeeklyPaymentAdapter :
    ListAdapter<WeeklyPayments, WeeklyPaymentAdapter.AdapterViewHolder>(MyDiffCallback()) {

    private var itemClickListener: ((WeeklyPayments) -> Unit)? = null

    fun setItemClickListener(listener: (WeeklyPayments) -> Unit) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(parent.viewBinding(PaymentsRowItemBinding::inflate))
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val remoteData = getItem(position)
        holder.bind(remoteData, itemClickListener)
    }


    class AdapterViewHolder(private val binding: PaymentsRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(
            remoteData: WeeklyPayments,
            clickListener: ((WeeklyPayments) -> Unit)?,
        ) {

            binding.paymentTv.text = "${String.format("%.2f", remoteData.earning)} $"
            binding.distanceTv.text = "${String.format("%.2f", remoteData.distance)} km"
            binding.completedDeliveriesTv.text = remoteData.deliveries

            binding.root.setOnClickListener { clickListener?.invoke(remoteData) }
        }
    }

    private class MyDiffCallback : DiffUtil.ItemCallback<WeeklyPayments>() {
        override fun areItemsTheSame(oldItem: WeeklyPayments, newItem: WeeklyPayments) =
            oldItem.deliveries == newItem.deliveries

        override fun areContentsTheSame(oldItem: WeeklyPayments, newItem: WeeklyPayments) =
            oldItem == newItem
    }

}