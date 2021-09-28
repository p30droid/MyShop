package com.androidlearn.digishop.ui.main.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.androidlearn.digishop.databinding.FragmentHomeBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidlearn.digishop.models.BaseModel
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback


class HomeFragment : Fragment()  {

    lateinit var binidng : FragmentHomeBinding;
    private lateinit var owner: LifecycleOwner
    lateinit var homeViewModel: HomeViewModel



    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binidng = FragmentHomeBinding.inflate(layoutInflater)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)



        return binidng.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        homeViewModel.getHome().observe(owner , object : Observer<BaseModel> {
            override fun onChanged(t: BaseModel?) {


                Log.e("","");


                var adapter = ProductAdapter(activity!!.applicationContext,t!!.mobile)
                binidng.recyclerView.adapter = adapter
                var manager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL , false)
                binidng.recyclerView.layoutManager = manager



                var adapter_makeup = ProductAdapter(activity!!.applicationContext,t!!.makeup)
                binidng.recyclerViewMakeup.adapter = adapter_makeup
                var manager_makeup = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL , false)
                binidng.recyclerViewMakeup.layoutManager = manager_makeup


               var adapter_discount = ProductAdapter(activity!!.applicationContext,t!!.discount)
                binidng.recyclerViewDiscount.adapter = adapter_discount
                var manager_discount = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL , false)
                binidng.recyclerViewDiscount.layoutManager = manager_discount


                binidng.progressbar.visibility = View.GONE

                val  newsAdapter = NewsAdapter(activity!!.applicationContext , t.news)
                binidng.pager.adapter = newsAdapter






            }

        })




    }




}