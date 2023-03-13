package com.example.fibonaccinumbergenerator.feature_generator.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fibonaccinumbergenerator.R
import com.example.fibonaccinumbergenerator.databinding.FibonacciNumberItemBinding
import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber
import com.example.fibonaccinumbergenerator.feature_generator.presentation.util.viewBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FibonacciNumbersAdapter :
    ListAdapter<FibonacciNumber, FibonacciNumbersAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fibonacci_number_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bindingItem by viewBinding(FibonacciNumberItemBinding::bind)

        fun bind(item: FibonacciNumber) = with(bindingItem) {
            tvNumber.text = item.number.toString()
            tvDate.text =
                SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(Date(item.timeStamp))
                    .toString()
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<FibonacciNumber>() {
        override fun areItemsTheSame(
            oldItem: FibonacciNumber,
            newItem: FibonacciNumber
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: FibonacciNumber,
            newItem: FibonacciNumber
        ): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        const val DATE_FORMAT = "dd/mm/yyyy hh:mm:ss"
    }
}