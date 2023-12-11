package com.example.apie_commers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apie_commers.databinding.ItemRcbBinding
import com.example.apie_commers.databinding.ItemRcbSlliderBinding
import com.example.apie_commers.datas.Product

class IStoreSliderAdapter(private var imageList: List<String>?) :
    RecyclerView.Adapter<IStoreSliderAdapter.ProductViewHolder>() {


    class ProductViewHolder(var binding: ItemRcbSlliderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemRcbSlliderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return imageList?.size ?: 0
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        imageList?.get(position).let {

            holder.binding.imageViewSlider.load(it)

        }


    }


}