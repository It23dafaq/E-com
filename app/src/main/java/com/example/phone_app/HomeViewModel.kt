package com.example.phone_app

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;

class HomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val users: MutableLiveData<List<Products>>  by lazy {
        MutableLiveData<List<Products>>().also {
            loadUsers()

        }
    }

    fun getUsers(): LiveData<List<Products>> {
        return users
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.

    }

}
