package com.migue.gar

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.migue.domain.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import usecase.GetFilm
import java.util.*
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase : GetFilm
):ViewModel(),LifecycleObserver{
    private val filmLiveData = MutableLiveData<FilmDataView>()
            val film:LiveData<FilmDataView> =filmLiveData

       fun loadFilm(id:Int){
           val language = Locale.getDefault().language

           job= CoroutineScope (Dispatchers.IO).launch{
               val loadedFilm= useCase.execute(600,language
               )
               withContext(Dispatchers.Main){
                   loadedFilm?.let {
                       filmLiveData.value= FilmDataView(
                           it.title,
                           it.rating,
                           it.description,
                           it.url,
                           it.director ?: ""
                       )





                   }
               }
           }
       }

    var job: Job?= null
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}