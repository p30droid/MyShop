package com.androidlearn.digishop.ui.productDetail

import android.content.Context
import com.androidlearn.digishop.models.New
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidlearn.digishop.R
import androidx.appcompat.widget.AppCompatImageView
import com.androidlearn.digishop.models.Gallery
import com.bumptech.glide.Glide

//import androidx.viewpager.widget.PagerAdapter;
class GalleryAdapter(var context: Context, var galleryList: List<Gallery>) : PagerAdapter() {
    override fun getCount(): Int {
        return galleryList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.news_row, null)
        val img_news: AppCompatImageView = view.findViewById(R.id.img_news)
        container.addView(view, 0)
        val (icon) = galleryList[position]
        Glide.with(view.context).load(icon)
            .into(img_news)
        return view
    }
}