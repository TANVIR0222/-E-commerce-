package com.example.apie_commers

import com.example.apie_commers.datas.Product
import com.example.apie_commers.datas.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//3
interface ApiServiceDAO {

    @GET(PRODUCTS)
    suspend fun getAllProduct () :Response<ResponseProduct>

    @GET(PRODUCT)
    suspend fun getProductByID (@Path ("id") id :Int ) :Response<Product>



}