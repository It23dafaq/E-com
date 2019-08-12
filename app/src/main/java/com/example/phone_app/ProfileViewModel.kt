package com.example.phone_app


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phone_app.Data.Person
import com.example.phone_app.Data.Products
import com.example.phone_app.UI.Adapters.HomeController
import com.example.phone_app.UI.ProfileController

class ProfileViewModel(private val profileController: ProfileController) : ScopedViewModel(){
    // TODO: Implement the ViewModel
    private val users: MutableLiveData<Person>  by lazy {
        MutableLiveData<Person>().also {
            loadUsers()

        }
    }

    fun getUsers(): LiveData<Person> {
        return users
    }

    private fun loadUsers() {
       }
}
