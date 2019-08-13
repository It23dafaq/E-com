package com.example.phone_app


import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phone_app.Data.Products
import com.example.phone_app.UI.Adapters.cartAdapter
import com.example.phone_app.UI.HomeViewModelFactory
import com.example.phone_app.UI.ShopViewModelFactory
import kotlinx.android.synthetic.main.shop_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class Shop : Fragment() , KodeinAware {
    override val kodein by closestKodein()
    private val viewModelFactory: HomeViewModelFactory by instance()
    companion object {

        @JvmStatic
        fun newInstance() =
            Shop().apply {
                arguments = Bundle().apply {
                    // putString(ARG_PARAM1, param1)
                }
            }
    }



    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_fragment, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
       // val bundle = arguments

        //   val cartArray: List<Products> = bundle!!.getParcelableArrayList<Products>("da")
        val cart = viewModel.getProduct()
        val adapter = cartAdapter(cart)
        shopcart.adapter=adapter
        shopcart.layoutManager = LinearLayoutManager(context!!)





    }

}
