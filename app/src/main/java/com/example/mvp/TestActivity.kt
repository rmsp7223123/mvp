package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTestBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(layoutInflater);
        setContentView(binding.root);
    }
}