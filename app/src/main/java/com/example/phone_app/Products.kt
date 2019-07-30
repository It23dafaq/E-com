package com.example.phone_app

import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName



@Entity(tableName = "products")
data class Products(



    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Float

)
