package com.example.myapplication.search.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_container)
        //val hostFragment =supportFragmentManager.findFragmentById(R.id.mainFragment) as NavHostFragment? ?: return
    }
}