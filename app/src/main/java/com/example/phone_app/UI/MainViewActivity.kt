package com.example.phone_app.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.phone_app.Home
import com.example.phone_app.Profile
import com.example.phone_app.R
import com.example.phone_app.Shop
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainViewActivity : AppCompatActivity() {
    companion object {
        const val PARAM_NAVIGATION_ID = "navigation_id"

        fun newInstance(context: Context, navigationId: Int) =  Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra(PARAM_NAVIGATION_ID, navigationId)
        }
    }

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
       /*
        when (item.itemId) {
            R.id.nav_home -> {
                textMessage.setText(R.string.title_home)

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_cart-> {
                textMessage.setText(R.string.title_shop)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile-> {
                textMessage.setText(R.string.title_profile)
                return@OnNavigationItemSelectedListener true
            }
        }
        */
        loadFragment(item.itemId)
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

       
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun loadFragment(itemId: Int) {
        val tag = itemId.toString()
        val fragment = supportFragmentManager.findFragmentByTag(tag) ?: when (itemId) {
            R.id.nav_home -> {
                Home.newInstance()
            }
            R.id.nav_cart -> {
                Shop.newInstance()
            }
            R.id.nav_profile -> {
                Profile.newInstance()
            }
            else -> {
                null
            }
        }

        // replace fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment as Fragment, tag)
                .commit()
        }
    }
}
