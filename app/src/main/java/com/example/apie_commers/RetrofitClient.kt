package com.example.apie_commers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//4
object RetrofitClient {

    private fun getRetrofitInstance() =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
// main activity work
    fun getApiDao () = getRetrofitInstance().create(ApiServiceDAO::class.java)

}