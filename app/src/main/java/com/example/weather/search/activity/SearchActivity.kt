package com.example.weather.search.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.weather.R
import com.example.weather.databinding.ActivitySearchBinding
import com.example.weather.extension.viewBinding

class SearchActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivitySearchBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initFragment()
    }

    private fun initFragment() {
       findNavController(R.id.constraintSearch).navigate(R.id.frameWeatherCity)
    }
}