package com.example.phone_app.Data.dataBase.Localized.dbAccessObject

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.phone_app.Data.Products
import com.example.phone_app.Data.dataBase.Localized.ImperialProducts

//database access objects is always interfaces Room documentation
@Dao
interface ProductsDao {
   //if some comflict like same id -> replace
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //update or insert
    fun upsert(productEntry:Products)
    @Query("select * from products")
    fun getProducts():LiveData<ImperialProducts>
}