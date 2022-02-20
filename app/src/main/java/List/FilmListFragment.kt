package List


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.migue.gar.FilmLauncher
import com.migue.gar.MyLog
import com.migue.gar.R
import com.migue.gar.databinding.FilmListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmsListFragment : Fragment() {
    lateinit var adapter: FilmListAdapter
    @Inject lateinit var myLog: MyLog

    private lateinit var binding: FilmListBinding
    private val viewModel: FilmViewModel by viewModels()
    private var filmLauncher: FilmLauncher? =null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        filmLauncher = context as? FilmLauncher
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState :Bundle?

    ):View {
        binding = FilmListBinding.inflate(layoutInflater)
        binding.root.adapter  =adapter
        val isTable = resources.getBoolean(R.bool.isTablet)
        if (isTable){
            binding.root.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        } else{
            binding.root.layoutManager = GridLayoutManager(context,2)
        }
        viewModel.loadFilms()
        viewModel.films.observe(this
        ){
            adapter.submitList(it)
        }
        adapter.callback={

        }
        adapter.callback={
            myLog.log(("click en la pelicula ${it.title}"))
            filmLauncher?.openDetails(it.id)



        }
        return binding.root
    }

}