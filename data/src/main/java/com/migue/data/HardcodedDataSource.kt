package com.migue.data

import com.migue.domain.Film
import javax.inject.Inject

class HardcodedDataSource @Inject constructor() {
     fun getFilm() = Film("Batman","" ,"" ,10.0)
}
