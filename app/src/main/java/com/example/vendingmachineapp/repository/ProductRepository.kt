package com.example.vendingmachineapp.repository

import com.example.vendingmachineapp.data.Product
import com.example.vendingmachineapp.data.ProductDao
import com.example.vendingmachineapp.utils.DummyDataHelper.getProduct
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val productDao : ProductDao
){
    fun insertDataProduct() {
        productDao.insertProduct(getProduct())
    }

    fun getDataProduct() {
        productDao.getDataProduct()
    }

    fun updateDataProduct(product: Product) {
        productDao.updateProduct(product)
    }
}