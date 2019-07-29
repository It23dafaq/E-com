package com.example.phone_app

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Deferred
import okhttp3.Response
import retrofit2.http.GET



data class Products(



    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int

)
