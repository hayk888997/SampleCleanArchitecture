package com.example.fibonaccinumbergenerator.common.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> RecyclerView.ViewHolder.viewBinding(viewBindingFactory: (View) -> T) =
    lazy { viewBindingFactory(itemView) }
