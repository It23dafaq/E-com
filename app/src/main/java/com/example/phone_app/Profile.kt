package com.example.phone_app


import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.phone_app.UI.HomeViewModelFactory
import com.example.phone_app.UI.ProfileViewModelFactory
import kotlinx.android.synthetic.main.profile_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class Profile : Fragment(),KodeinAware {
    override val kodein by closestKodein()

    /* activity specific bindings */
    private val viewModelFactory: ProfileViewModelFactory by instance()
    companion object {

        @JvmStatic
        fun newInstance() =
            Profile().apply {
                arguments = Bundle().apply {
                    // putString(ARG_PARAM1, param1)
                }
            }
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
         viewModel.getUsers().observe(this, Observer {
             UserName.text = it.toString()
         })
    }

}
