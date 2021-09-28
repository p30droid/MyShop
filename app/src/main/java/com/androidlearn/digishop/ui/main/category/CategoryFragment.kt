package com.androidlearn.digishop.ui.main.category

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.androidlearn.digishop.R
import com.androidlearn.digishop.databinding.FragmentCategoryBinding
import com.androidlearn.digishop.models.Category


class CategoryFragment : Fragment() {

    lateinit var binding : FragmentCategoryBinding
    lateinit var viewModel: CategoryViewModel
    private lateinit var owner: LifecycleOwner


/*
    fun attach(fragment: CategoryFragment) {
        owner = fragment
    }
*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        viewModel.category.observe(owner, object : Observer<List<Category>> {

            override fun onChanged(t: List<Category>?) {


                binding.progressBar.visibility = View.GONE


                var adapter =  CategoryAdapter(t!!)

                binding.recyclerCategory.adapter = adapter

                var manager = GridLayoutManager(activity!!.applicationContext , 2)
                binding.recyclerCategory.layoutManager = manager





            }


        })


    }


}