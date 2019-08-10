package com.example.phone_app

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phone_app.UI.Adapters.cartAdapter
import kotlinx.android.synthetic.main.shop_fragment.*


class Shop : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() =
            Shop().apply {
                arguments = Bundle().apply {
                    // putString(ARG_PARAM1, param1)
                }
            }
    }



    private lateinit var viewModel: ShopViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShopViewModel::class.java)
        // TODO: Use the ViewModel

        val adapter = cartAdapter(Home.cachedList)
        shopcart.adapter=adapter
            shopcart.layoutManager = LinearLayoutManager(context!!)
    }

}
