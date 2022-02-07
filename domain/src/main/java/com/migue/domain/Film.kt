package com.migue.domain

  data class Film(
      val title: String,
      val id:Int,
      val url: String,
      val name: String,
      val description: String,
      val director: String?,
      val rating:Double,
      val videoId:String?
  )