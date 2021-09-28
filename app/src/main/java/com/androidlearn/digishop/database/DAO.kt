package com.androidlearn.digishop.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.androidlearn.digishop.models.Product

@Dao
interface DAO {

    @Query("SELECT * FROM tbl_product")
    fun getAll(): List<Product>

    @Query("SELECT * FROM tbl_product WHERE uid IN (:productIds)")
    fun loadAllByIds(productIds: IntArray): List<Product>

    @Insert
    fun insertAll(vararg product: Product)

    @Delete
    fun delete(product: Product)


    @Query("SELECT EXISTS(SELECT * FROM tbl_product WHERE id = :id)")
    fun isRowIsExist(id : Int) : Boolean



    @Query("SELECT SUM(price)  FROM tbl_product")
    fun calculatePrice() : String

}