package com.example.phone_app

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://rectifiable-merchan.000webhostapp.com/e_com/"

interface ProductApi {

    @GET("present_json_array.php")
    fun getProducts() : Deferred <List<Products>>

    companion object {
        operator fun invoke() : ProductApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL).addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductApi::class.java)


        }
    }
}