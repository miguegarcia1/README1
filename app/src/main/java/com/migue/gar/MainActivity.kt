package com.migue.gar
import List.FilmsListFragment
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.migue.gar.databinding.MainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : FragmentActivity(), FilmLauncher {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.list, FilmsListFragment())
            .commit()


    }

    override fun openDetails(id: Int) {
        val fragment = FilmFragment()
        fragment.arguments = Bundle().apply {
            putInt(FilmFragment.FILM_ID, id)
        }
        val isTable = resources.getBoolean(R.bool.isTablet)
        if (isTable) {
            supportFragmentManager.beginTransaction()
                .add(R.id.detail, FilmsListFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.list, FilmsListFragment())
                .addToBackStack("BACKSTACK")
                .commit()
        }
    }
}