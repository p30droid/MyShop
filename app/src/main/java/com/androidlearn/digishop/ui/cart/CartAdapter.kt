package com.androidlearn.digishop.ui.cart

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidlearn.digishop.R
import com.androidlearn.digishop.databinding.CartRowBinding
import com.androidlearn.digishop.databinding.ProductRowBinding
import com.androidlearn.digishop.models.Product
import com.androidlearn.digishop.ui.productDetail.ProductActivity
import com.bumptech.glide.Glide

class CartAdapter(context : Context, myList: List<Product>) : RecyclerView.Adapter<CartAdapter.ProductVh>() {

    lateinit var cartRowBinding: CartRowBinding
    var context : Context
    var productList: List<Product>

    init {
        productList = myList
        this.context= context
    }

    class ProductVh(cartRowBinding: CartRowBinding) :
        RecyclerView.ViewHolder(cartRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVh {

        cartRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.cart_row,
            parent,
            false
        )

        var productVh = ProductVh(cartRowBinding)
        return productVh
    }

    override fun onBindViewHolder(holder: ProductVh, position: Int) {

        var product : Product = productList.get(position)
        cartRowBinding.product = product

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    companion object {

        @JvmStatic
        @BindingAdapter("profileImage")
        fun showImage(image : AppCompatImageView , url : String ) {
            Glide.with(image.context).load(url).into(image)

        }


        @JvmStatic
        @BindingAdapter("titleMessage")
        fun title(textView : AppCompatTextView , text : String) {

            if(text.length>=20) {

                var newTitle = text.substring(0,19);
                textView.setText(newTitle)


            }else {
                textView.setText(text)
            }

        }

        @JvmStatic
        @BindingAdapter("ClickItem")
        fun click(cardView: CardView, product: Product) {
            cardView.setOnClickListener { view: View? ->
                val intent = Intent(
                    cardView.context,
                    ProductActivity::class.java
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("product", product)
                Log.e("product" , product.title)
                cardView.context.startActivity(intent)
            }
        }

    }



}