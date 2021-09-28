package com.androidlearn.digishop.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androidlearn.digishop.models.Product
import com.androidlearn.digishop.utils.TypeConvertor

@Database(entities = arrayOf(Product::class), version = 1 , exportSchema = false)
//@TypeConverters(TypeConverters::class)
@TypeConverters(TypeConvertor::class)
abstract  class AppDatabase : RoomDatabase()  {
    abstract fun dao(): DAO

}