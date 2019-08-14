package com.example.phone_app



import com.example.phone_app.Data.Products
import com.example.phone_app.UI.Adapters.HomeController
import timber.log.Timber

var addcart : MutableList<Products> = ArrayList()
class HomeViewModel(private val homeController: HomeController) : ScopedViewModel() {
    // TODO: Implement the ViewModel

    var products = homeController.downloadProduct
    fun addProduct(list: Products) {
        addcart.add(list)

    }
    fun RemoveProduct(id: Int) {
        addcart.removeAt(id)


    }
    fun  getProduct(): MutableList<Products> {
        return addcart

    }
    fun getUsers(){
        launchWithLoad({
            homeController.getUsers()

        }){}
    }



    }










