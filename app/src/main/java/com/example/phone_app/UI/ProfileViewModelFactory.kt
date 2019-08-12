package com.example.phone_app.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.phone_app.HomeViewModel
import com.example.phone_app.ProfileViewModel
import com.example.phone_app.UI.Adapters.HomeController

class ProfileViewModelFactory(private val profileController: ProfileController): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(profileController) as T
    }
}