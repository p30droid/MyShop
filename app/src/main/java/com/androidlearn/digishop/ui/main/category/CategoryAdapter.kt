package com.androidlearn.digishop.ui.main.category

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidlearn.digishop.R
import com.androidlearn.digishop.databinding.CatRowBinding
import com.androidlearn.digishop.models.Category
import com.androidlearn.digishop.models.Product
import com.androidlearn.digishop.ui.productDetail.ProductActivity
import com.bumptech.glide.Glide

class CategoryAdapter(category : List<Category>) : RecyclerView.Adapter<CategoryVH>() {

    lateinit var binding : CatRowBinding

     var categoryList : List<Category>
    init {
        categoryList = category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context) ,
        R.layout.cat_row , parent , false)
        var vh = CategoryVH(binding);
        return vh

    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {

        var category = categoryList.get(position);
        binding.category = category


    }

    override fun getItemCount(): Int {
        return  categoryList.size
    }






    companion object {

        @JvmStatic
        @BindingAdapter("profileImage")
        fun showImage(image : AppCompatImageView, url : String ) {
            Glide.with(image.context).load(url).into(image)

        }


        @JvmStatic
        @BindingAdapter("ClickItem")
        fun click(cardView: CardView, product: Category) {
            cardView.setOnClickListener { view: View? ->
                val intent = Intent(
                    cardView.context,
                    ProductActivity::class.java
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("product", product)
               // cardView.context.startActivity(intent)
            }
        }

    }


















}