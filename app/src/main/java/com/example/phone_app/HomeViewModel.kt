package com.example.phone_app

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import android.graphics.Movie
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.OkHttpClient
import android.os.AsyncTask.execute
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.ResponseBody
import java.io.IOException


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



