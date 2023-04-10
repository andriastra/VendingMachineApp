package com.example.vendingmachineapp.utils

import com.example.vendingmachineapp.data.Product

object DummyDataHelper {

    fun getProduct() : MutableList<Product> {
        val masterList = Product(
            id = 1,
            name = "Aqua",
            qty = 10,
            price = 5000
        )
        return mutableListOf(
            masterList,
            masterList.copy(id = 2, name = "Teh Botol", qty = 28, price = 7000),
            masterList.copy(id = 3, name = "Pocari Sweat", qty = 18, price = 7000),
            masterList.copy(id = 4, name = "Coca Cola", qty = 5, price = 7000)
        )
    }
}