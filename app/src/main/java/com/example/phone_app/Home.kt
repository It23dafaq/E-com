package com.example.phone_app

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phone_app.Data.Products
import com.example.phone_app.Network.ConnectivityInterceptorImpl
import com.example.phone_app.Network.ProductApi
import com.example.phone_app.Network.ProductNetworkDataSource
import com.example.phone_app.Network.ProductNetworkDataSourceImpl
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Home : Fragment() {


    companion object {
        var cachedList:MutableList<Products> = ArrayList()
        @JvmStatic
        fun newInstance() =
            Home().apply {
                arguments = Bundle().apply {
                    // putString(ARG_PARAM1, param1)
                }
            }
    }

    private lateinit var viewModel: HomeViewModel
//    private val cachedList: LiveData<List<Products>> = List<Products>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
      val apiServic = ProductApi(ConnectivityInterceptorImpl(this.context!!))
        val productNetworkDataSource = ProductNetworkDataSourceImpl(apiServic)

        productNetworkDataSource.downloadProduct.observe(this, Observer {

                //textView4.text= it.toString()


                val adapter = ProductAdapter(cachedList)
            recyclerproducts.adapter = adapter
                recyclerproducts.layoutManager = LinearLayoutManager(context!!)
                recyclerproducts.layoutManager.isAutoMeasureEnabled
                //  textView4.text=it.toString()
            cachedList.addAll(it!!)

        })



        GlobalScope.launch(Dispatchers.Main) {
            productNetworkDataSource.fetchCurrentWeather()
        }

    }


}
