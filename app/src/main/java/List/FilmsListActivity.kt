package List

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.migue.gar.MainViewModel
import com.migue.gar.databinding.FilmListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsListActivity : AppCompatActivity() {
    lateinit var adapter: FilmListAdapter

    private lateinit var binding: FilmListBinding
    private val viewModel: FilmViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)
         binding.root.adapter  =adapter
         viewModel.loadFilms()
        viewModel.films.observe(this
        ){
            adapter.submitList(it)
        }

        }

    }