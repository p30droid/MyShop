package com.androidlearn.digishop.ui.productDetail.descriptionDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidlearn.digishop.R
import com.androidlearn.digishop.databinding.ActivityDescriptionBinding
import com.androidlearn.digishop.models.Product

class DescriptionActivity : AppCompatActivity() {

    lateinit var  binding : ActivityDescriptionBinding
    lateinit var bundle: Bundle
    lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescriptionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        bundle = intent.extras!!
        product = bundle.getParcelable<Product>("product")!!

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.txtFullDescription.setText(product.fullDescription)

    }
}