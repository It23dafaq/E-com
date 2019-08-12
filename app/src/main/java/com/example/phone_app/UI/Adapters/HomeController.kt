package com.example.phone_app.UI.Adapters

import com.example.phone_app.Network.ProductApi


class HomeControllerIml(
    private val productService: ProductApi
):HomeController {
    override suspend fun getUsers() {
        productService.getProducts().await()
    }
}

interface HomeController {

    suspend fun getUsers()
}