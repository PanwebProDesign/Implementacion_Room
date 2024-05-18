package com.protectly.sqllite

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.protectly.sqllite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //declaramos viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializamos viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}