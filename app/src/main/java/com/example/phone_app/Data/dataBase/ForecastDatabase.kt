package com.example.phone_app.Data.dataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.phone_app.Data.Products
import com.example.phone_app.Data.dataBase.Localized.dbAccessObject.ProductsDao

@Database(
    entities=[Products::class],
    version = 1
)

 abstract class ForecastDatabase: RoomDatabase() {
  abstract fun productDao(): ProductsDao

    companion object{
    @Volatile private var instance: ForecastDatabase? = null
    private val LOCK = Any()
//if is null build it
        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{ instance=it}
        }
        private fun buildDatabase(context: Context)=
                Room.databaseBuilder(context.applicationContext,ForecastDatabase::class.java,"forecast.db").build()
    }
}