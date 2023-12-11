package com.example.apie_commers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apie_commers.datas.Product
import com.example.apie_commers.datas.ResponseProduct
import kotlinx.coroutines.launch

//5
class MainViewModel :ViewModel() {

    private val _allProductResponse = MutableLiveData<ResponseProduct>()
    val allProductResponse : LiveData<ResponseProduct> = _allProductResponse

    fun getAllProduct () {

        viewModelScope.launch {
            val data =   RetrofitClient.getApiDao().getAllProduct().body()
            _allProductResponse .postValue(data)

        }
    }



    private val _productResponse = MutableLiveData<Product>()
    val productResponse : LiveData<Product> = _productResponse


    fun getProductByID (pid : Int) {

        viewModelScope.launch {
            val data =   RetrofitClient.getApiDao().getProductByID(pid).body()
            _productResponse .postValue(data)

        }
    }

}