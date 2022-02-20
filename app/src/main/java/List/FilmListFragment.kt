package List


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.migue.gar.MyLog
import com.migue.gar.databinding.FilmListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmsListFragment : Fragment() {
    lateinit var adapter: FilmListAdapter
    @Inject lateinit var myLog: MyLog

    private lateinit var binding: FilmListBinding
    private val viewModel: FilmViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState :Bundle?

    ):View {
        binding = FilmListBinding.inflate(layoutInflater)
        binding.root.adapter  =adapter
        viewModel.loadFilms()
        viewModel.films.observe(this
        ){
            adapter.submitList(it)
        }
        adapter.callback={

        }
        adapter.callback={
            myLog.log(("click en la pelicula ${it.title}"))



        }
        return binding.root
    }

}