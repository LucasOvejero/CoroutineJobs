package com.example.myapplication.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utils.mvvm.makeViewModel

class DetailFragment : Fragment() {
    private lateinit var searchViewModel: SearchViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        searchViewModel = makeViewModel(SearchViewModel.factory())
        binding.viewModel = searchViewModel
        binding.lifecycleOwner = this
        binding.rvFoodList.addItemDecoration(VerticalSpaceItemDecoration(5))
        binding.rvFoodList.adapter = FoodAdapter()
        binding.rvFoodList.layoutManager = LinearLayoutManager(context)
        binding.dtBuscador.doAfterTextChanged {
            if (it != null) searchViewModel.searchFood(it.toString())
        }

        searchViewModel.recipesLiveData.observe(viewLifecycleOwner) {
            binding.rvFoodList.adapter = FoodAdapter(it)
        }
        return binding.root
        // return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

    }
}