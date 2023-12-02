package pl.ozodbek.viewpager2fragmentspractice.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.ozodbek.viewpager2fragmentspractice.data.DailyPayments
import pl.ozodbek.viewpager2fragmentspractice.databinding.PaymentsRowItemBinding
import pl.ozodbek.viewpager2fragmentspractice.utils.viewBinding

class DailyPaymentAdapter :
    ListAdapter<DailyPayments, DailyPaymentAdapter.AdapterViewHolder>(MyDiffCallback()) {

    private var itemClickListener: ((DailyPayments) -> Unit)? = null

    fun setItemClickListener(listener: (DailyPayments) -> Unit) {
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
            remoteData: DailyPayments,
            clickListener: ((DailyPayments) -> Unit)?,
        ) {

            binding.paymentTv.text = "${String.format("%.2f", remoteData.earning)} $"
            binding.distanceTv.text = "${String.format("%.2f", remoteData.distance)} km"
            binding.completedDeliveriesTv.text = remoteData.deliveries

            binding.root.setOnClickListener { clickListener?.invoke(remoteData) }
        }
    }

    private class MyDiffCallback : DiffUtil.ItemCallback<DailyPayments>() {
        override fun areItemsTheSame(oldItem: DailyPayments, newItem: DailyPayments) =
            oldItem.deliveries == newItem.deliveries

        override fun areContentsTheSame(oldItem: DailyPayments, newItem: DailyPayments) =
            oldItem == newItem
    }

}