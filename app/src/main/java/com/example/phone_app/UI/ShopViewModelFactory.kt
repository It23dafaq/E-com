package com.example.phone_app.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.phone_app.ShopViewModel

class ShopViewModelFactory(private val shopController: ShopController): ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopViewModel(shopController) as T
    }

}
