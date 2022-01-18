package com.migue.gar

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class FilmDataView(val title:String)
private val filmLiveData= MutableLiveData<FilmDataView>()
val film:LiveData<FilmDataView> = filmLiveData


