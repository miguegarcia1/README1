package com.migue.gar
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.migue.gar.databinding.MainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState :Bundle?){
       super.onCreate(savedInstanceState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}