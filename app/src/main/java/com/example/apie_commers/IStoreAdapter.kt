package com.example.apie_commers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apie_commers.databinding.ItemRcbBinding
import com.example.apie_commers.datas.Product

class IStoreAdapter(var productList: List<Product>?, val listener: Listener) :
    RecyclerView.Adapter<IStoreAdapter.ProductViewHolder>() {

    fun interface Listener {
        fun onItemClick(pid: Int)
    }

    class ProductViewHolder(var binding: ItemRcbBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemRcbBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return productList?.size ?: 0
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        productList?.get(position)?.let { product ->

            holder.binding.apply {

                Brand.text = product.brand
                off.text = "OFF   :${product.discountPercentage} %"
                price.text = "Price :$${product.price} "
                stock.text = "Stock :${product.stock}"
                name.text = product.title

                imageView.load(product.thumbnail)

            }

            holder.itemView.setOnClickListener {
                listener.onItemClick(product.id)
            }


        }


    }


}