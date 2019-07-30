package com.example.phone_app

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.example.phone_app.Data.Products


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
//        // Do an asynchronous operation to fetch users.
//        ProductApi().getMovies().enqueue(object : retrofit2.Callback<List<Products>> {
//            override fun onFailure(call: retrofit2.Call<List<Products>>, t: Throwable) {
//                print(t.message)
//            }
//
//            override fun onResponse(
//                call: retrofit2.Call<List<Products>>,
//                response: retrofit2.Response<List<Products>>
//            ) {
//
//               val body  = response.body()
//                print(body)
//               val gson = GsonBuilder().create()
//                      body?.let {
//                    ProductAdapter(body) }
//
//
//            }





       // })



    }






}



