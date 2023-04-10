package com.example.vendingmachineapp

import androidx.lifecycle.ViewModel
import com.example.vendingmachineapp.data.Product
import com.example.vendingmachineapp.repository.ProductRepository
import javax.inject.Inject

class VendingViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel() {
    fun insertProduct() {
        repository.insertDataProduct()
    }
    fun getDataProduct() {
        repository.getDataProduct()
    }
    fun updateDataProduct(product: Product) {
        repository.updateDataProduct(product)
    }
}