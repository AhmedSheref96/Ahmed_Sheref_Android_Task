package com.el3asas.ahmed_sheref_android_task.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.el3asas.ahmed_sheref_android_task.databinding.ItemProductHomeBinding
import com.el3asas.ahmed_sheref_android_task.databinding.ItemProductStochMore50Binding
import com.el3asas.ahmed_sheref_android_task.models.ProductsItem

class ProductsAdapter(
    private val itemCLickListener: ProductItemCLickListener
) : RecyclerView.Adapter<ProductsAdapter.MainViewHolder>() {

    val bindingInflaterSmall: (LayoutInflater) -> ViewDataBinding = ItemProductHomeBinding::inflate
    val bindingInflaterBig: (LayoutInflater) -> ViewDataBinding =
        ItemProductStochMore50Binding::inflate
    private lateinit var list: List<ProductsItem>

    override fun getItemCount() = if (this::list.isInitialized) list.size else 0

    class MainViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ProductsItem>) {
        list = data
        notifyDataSetChanged()
    }

    fun getItem(position: Int) = list[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return when (viewType) {
            0 -> MainViewHolder(bindingInflaterSmall(LayoutInflater.from(parent.context)))
            else -> MainViewHolder(bindingInflaterBig(LayoutInflater.from(parent.context)))
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = list[position]
        when (getItemViewType(position)) {
            0 -> {
                val binding = holder.binding as ItemProductHomeBinding
                binding.viewModel = item
            }
            else -> {
                val binding = holder.binding as ItemProductStochMore50Binding
                binding.viewModel = item
            }
        }
        holder.itemView.setOnClickListener {
            itemCLickListener.onProductItemClickListener(it, position, item)
        }
    }

    override fun getItemViewType(position: Int) = when {
        list[position].stock!! <= 50 -> 0
        else -> -1
    }

    interface ProductItemCLickListener {
        fun onProductItemClickListener(v: View, position: Int, item: ProductsItem)
    }

}