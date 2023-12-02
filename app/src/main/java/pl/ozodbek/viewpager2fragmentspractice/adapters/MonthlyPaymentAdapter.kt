package pl.ozodbek.viewpager2fragmentspractice.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.ozodbek.viewpager2fragmentspractice.data.MonthlyPayments
import pl.ozodbek.viewpager2fragmentspractice.databinding.PaymentsRowItemBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class MonthlyPaymentAdapter :
    ListAdapter<MonthlyPayments, MonthlyPaymentAdapter.AdapterViewHolder>(MyDiffCallback()) {

    private var itemClickListener: ((MonthlyPayments) -> Unit)? = null

    fun setItemClickListener(listener: (MonthlyPayments) -> Unit) {
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
            remoteData: MonthlyPayments,
            clickListener: ((MonthlyPayments) -> Unit)?,
        ) {

            binding.paymentTv.text = "${String.format("%.2f", remoteData.earning)} $"
            binding.distanceTv.text = "${String.format("%.2f", remoteData.distance)} km"
            binding.completedDeliveriesTv.text = remoteData.deliveries

            binding.root.setOnClickListener { clickListener?.invoke(remoteData) }
        }
    }

    private class MyDiffCallback : DiffUtil.ItemCallback<MonthlyPayments>() {
        override fun areItemsTheSame(oldItem: MonthlyPayments, newItem: MonthlyPayments) =
            oldItem.deliveries == newItem.deliveries

        override fun areContentsTheSame(oldItem: MonthlyPayments, newItem: MonthlyPayments) =
            oldItem == newItem
    }

}