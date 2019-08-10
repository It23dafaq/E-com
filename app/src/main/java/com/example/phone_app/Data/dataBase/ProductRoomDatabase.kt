package com.example.phone_app.Data.dataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.phone_app.Data.Products
import com.example.phone_app.Data.dataBase.Localized.dbAccessObject.ProductsDao

@Database(entities = [Products::class], version = 1)
public abstract class ProductRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): ProductsDao

    companion object {
        @Volatile
        private var INSTANCE: ProductRoomDatabase? = null

        fun getDatabase(context: Context): ProductRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductRoomDatabase::class.java,
                    "Word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}