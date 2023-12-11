package com.example.apie_commers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms.Intents
import android.util.Log
import androidx.activity.viewModels
import com.example.apie_commers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    private lateinit var iStoreProductAdapter : IStoreAdapter

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getAllProduct()

        viewModel.allProductResponse.observe(this){ response ->

            Log.d("TAG", "onCreate: ${response.products}")

            iStoreProductAdapter = IStoreAdapter(response.products){
                val intent = Intent(this@MainActivity , DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.KEY , it)
                startActivity(intent)
            }

            binding.productRcv.adapter = iStoreProductAdapter

        }


    }
}