package com.example.vendingmachineapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduct(product: List<Product>)

    @Update
    fun updateProduct(product: Product)

    @Query("SELECT * FROM table_product ORDER BY id")
    fun getDataProduct(): LiveData<List<Product>>


}