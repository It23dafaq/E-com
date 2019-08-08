package com.example.phone_app

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.example.phone_app.Data.Person
import com.example.phone_app.Data.Products

class ProfileViewModel : ViewModel() {
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
