package com.migue.gar

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.migue.gar.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import usecase.GetFilm
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
     @Inject
     lateinit var log:MyLog
     @Inject
     lateinit var usecase: GetFilm
 private lateinit var binding: ActivityMainBinding
 private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       viewModel.loadFilm(512195)
        viewModel.film.observe(this){
            binding.ratingBar2.rating = it.rating.toFloat()
            binding.textView2.text= it.title
            binding.textView4.text = it.description
            binding.textView5.text = it.director
            Glide.with(this).load(it.imageUrl).into(binding.imageView)
        }

    }



    override fun onStart() {
        super.onStart()
        log.log("se inicia la aplicacion")
    }


    override fun onResume() {
        super.onResume()
        log.log("sale del estado invisble")

    }

    override fun onRestart() {
        super.onRestart()
        log.log("onRestart")
    }
    override fun onStop() {
        super.onStop()
      log.log("la aplicacion se ha parado")
    }

    override fun onDestroy() {
        super.onDestroy()
        log.log("la aplicacion se ha destruido")
    }

}


