package com.androidlearn.digishop.ui.main.home

import android.content.Context
import com.androidlearn.digishop.models.New
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidlearn.digishop.R
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

//import androidx.viewpager.widget.PagerAdapter;
class NewsAdapter(var context: Context, var newsList: List<New>) : PagerAdapter() {
    override fun getCount(): Int {
        return newsList.size
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
        val (icon) = newsList[position]
        Glide.with(view.context).load(icon)
            .into(img_news)
        return view
    }
}