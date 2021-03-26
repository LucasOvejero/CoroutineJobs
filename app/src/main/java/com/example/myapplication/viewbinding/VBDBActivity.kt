package com.example.myapplication.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myapplication.databinding.ActivityVbdbBinding

class VBDBActivity : AppCompatActivity() {
    private lateinit var viewModel: VBDBViewModel
    private lateinit var binding: ActivityVbdbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVbdbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}