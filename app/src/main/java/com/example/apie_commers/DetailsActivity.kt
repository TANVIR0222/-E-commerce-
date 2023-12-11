package com.example.apie_commers

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.apie_commers.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val KEY = "DetailsActivity"
    }


    private lateinit var binding :ActivityDetailsBinding

    val viewModel : MainViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val pid  =  intent.getIntExtra(KEY , 0)

        if (pid != 0 ){

            getProductBYId(pid)
        }


        setProductObserver()

    }

    @SuppressLint("SetTextI18n")
    private fun setProductObserver() {

        viewModel.productResponse.observe(this) { product ->


            binding.apply {
                Brand.text = product.brand
                off.text = "OFF   :${product.discountPercentage} %"
                price.text = "Price :$${product.price} "
                stock.text = "Stock :${product.stock}"
                name.text = product.title

                setImageSlider(product.images)

            }





        }

    }

    private fun setImageSlider(images: List<String>?) {

        if (!images .isNullOrEmpty()){
            binding.imageView.adapter = IStoreSliderAdapter(images)

        }
        

    }

    private fun getProductBYId(pid: Int) {

        viewModel.getProductByID(pid)

    }
}