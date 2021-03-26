package com.example.myapplication.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utils.mvvm.makeViewModel

class SearchFragment : Fragment() {
    lateinit var viewModel: SearchViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = ActivityMainBinding.inflate(inflater)
        //setContentView(binding.root)
        viewModel = makeViewModel(SearchViewModel.factory())
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.rvFoodList.adapter = FoodAdapter()
        binding.rvFoodList.addItemDecoration(VerticalSpaceItemDecoration(10))
        binding.rvFoodList.layoutManager = LinearLayoutManager(context)
        binding.dtBuscador.doAfterTextChanged {
            if (it != null) viewModel.searchFood(it.toString())
        }

        viewModel.recipesLiveData.observe(viewLifecycleOwner) {
            binding.rvFoodList.adapter = FoodAdapter(it, ::onClickListener)
        }
        return binding.root
    }

    private fun onClickListener(id:String) {
        Toast.makeText(context,id,Toast.LENGTH_SHORT).show()
       // Toast.makeText(this,id, Toast.LENGTH_SHORT).show()
    }
}