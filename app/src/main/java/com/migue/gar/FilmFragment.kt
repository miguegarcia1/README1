package com.migue.gar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.migue.gar.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import usecase.GetFilm
import javax.inject.Inject

@AndroidEntryPoint
class FilmFragment : Fragment() {
    companion object{
        const val FILM_ID = "ID"
    }
    @Inject
    lateinit var log:MyLog
    @Inject
    lateinit var usecase: GetFilm
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View {
         binding = ActivityMainBinding.inflate(layoutInflater)
        val id = arguments?.getInt(FILM_ID) ?: 512195
        viewModel.loadFilm(id)

        viewModel.film.observe(this){
            binding.ratingBar2.rating = it.rating.toFloat()
            binding.textView2.text= it.title
            binding.textView4.text = it.description
            binding.textView5.text = it.director
            Glide.with(this).load(it.imageUrl).into(binding.imageView)

            if(it.VideoId == null){
                binding.button2.visibility = View.GONE
            }else{
                binding.button2.visibility = View.VISIBLE
                binding.button.setOnClickListener { _ ->
                    launchYouTube(it.VideoId)
                }
            }



        }
        return binding.root
    }
    private fun launchYouTube(id:String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://.youtube.com/watch?v==$id"))
        startActivity(intent)

    }






    override fun onStart() {
        super.onStart()
        log.log("se inicia la aplicacion")
    }


    override fun onResume() {
        super.onResume()
        log.log("sale del estado invisble")

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


