package com.example.vendingmachineapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [(Product::class)], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun ProductDao() :ProductDao
}