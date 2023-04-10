package com.example.vendingmachineapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_product")
data class Product(
    @PrimaryKey
    val id: Int,
    val name: String,
    var qty:Int,
    var price: Int,
    var selected: Boolean = false
)
