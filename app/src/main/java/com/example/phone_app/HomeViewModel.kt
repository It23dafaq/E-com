package com.example.phone_app



import com.example.phone_app.UI.Adapters.HomeController
import timber.log.Timber


class HomeViewModel(private val homeController: HomeController) : ScopedViewModel() {
    // TODO: Implement the ViewModel




    fun getUsers(){
        launchWithLoad({
            homeController.getUsers()
        }){
            Timber.d("WOULD CRASH")
        }

    }



    }










