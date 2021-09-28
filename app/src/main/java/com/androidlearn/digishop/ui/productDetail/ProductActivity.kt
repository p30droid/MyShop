package com.androidlearn.digishop.ui.productDetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import androidx.viewpager.widget.ViewPager
import com.androidlearn.digishop.R
import com.androidlearn.digishop.database.AppDatabase
import com.androidlearn.digishop.databinding.ActivityProductBinding
import com.androidlearn.digishop.models.Gallery
import com.androidlearn.digishop.models.Product
import com.androidlearn.digishop.ui.cart.CartActivity
import com.androidlearn.digishop.ui.productDetail.descriptionDetail.DescriptionActivity

class ProductActivity : AppCompatActivity() {


    lateinit var bundle: Bundle

    lateinit var product: Product
    lateinit var binding: ActivityProductBinding

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)
        context = applicationContext
        //setContentView(binding.root)


        bundle = intent.extras!!
        //   // product = bundle.getParcelable<Product>("product")!!
        //  product  = bundle.getParcelable<Product>("product") as Product
        product = bundle.getParcelable<Product>("product")!!


        binding.product = product

        binding.executePendingBindings()


        binding.imgCart.setOnClickListener {
            imgBasket()
        }
        binding.imgBack.setOnClickListener {
            finish()
        }
        binding.btnAddMore.setOnClickListener {
            var intent = Intent(applicationContext, DescriptionActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }

    }

    companion object {


        @JvmStatic
        @BindingAdapter("adapter")
        fun adapter(pager: ViewPager, gallery: List<Gallery>) {

            var adapter = GalleryAdapter(pager.context, gallery)
            pager.adapter = adapter


        }
    }

    fun imgBasket() {

        //  val intent = Intent (applicationContext , CartActivity::class.java)

        //startActivity(intent)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "note.db"
        ).allowMainThreadQueries().build()

        if (db.dao().isRowIsExist(product.id.toInt())) {

        } else {
            db.dao().insertAll(product)
            Toast.makeText(
                applicationContext, getString(R.string.add_basket),
                Toast.LENGTH_LONG
            ).show()
        }


        //  val intent = Intent (applicationContext , CartActivity::class.java)

        //  startActivity(intent)


    }


}