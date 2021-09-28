package com.androidlearn.digishop.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.androidlearn.digishop.R
import com.androidlearn.digishop.database.AppDatabase
import com.androidlearn.digishop.databinding.ActivityCartBinding
import com.androidlearn.digishop.ui.main.home.ProductAdapter

class CartActivity : AppCompatActivity() {



    lateinit var binding : ActivityCartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "note.db"
        ).allowMainThreadQueries().build()

        var myCart = db.dao().getAll()
        var adapter = CartAdapter(this , myCart)

        binding.recyclerCart.adapter = adapter
        var manager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
        binding.recyclerCart.layoutManager = manager

        binding.imgBack.setOnClickListener {
            finish()
        }


        binding.txtPay.setText("${db.dao().calculatePrice()}")


    }
}