package com.example.vendingmachineapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vendingmachineapp.base.BaseRecycleAdapter
import com.example.vendingmachineapp.data.Product
import com.example.vendingmachineapp.databinding.ItemProductBinding

class ProductAdapter : BaseRecycleAdapter<Product>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateProduct(data: Product) {
        masterList.clear()
//        masterList.replaceAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        )

    inner class ViewHolder(itemView: View) : BaseViewHolder<Product>(itemView) {

        private val binding = ItemProductBinding.bind(itemView)

        init {
            binding.productName.setOnClickListener {

                onItemClicked?.invoke(masterList[adapterPosition])
            }
        }

        override fun bind(data: Product) {
            with(binding) {
                productName.text = data.name
            }
        }
    }
}