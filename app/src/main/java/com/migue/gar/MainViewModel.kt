package com.migue.gar

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import usecase.GetFilm
import java.util.*
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase : GetFilm
):ViewModel(),LifecycleObserver{
    private val filmLiveData = MutableLiveData<Film>()
            val film:LiveData<Film> =filmLiveData

       fun loadFilm(id:Int){
           val language = Locale.getDefault().language

           job= coroutineScope (Dispatchers.IO).Launch{
               val loadedFilm= usecase.execute(600,language
               )
           }
       }

    var job: job?= null
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}