package com.migue.gar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
     @Inject
     lateinit var log:MyLog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       log.log("se ha creado la aplicacion ")

    }

    override fun onStart() {
        super.onStart()
        log.log("se inicia la aplicacion")
    }


    override fun onResume() {
        super.onResume()
        log.log("sale del estado invisble")

    }

    override fun onRestart() {
        super.onRestart()
        log.log("onRestart")
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


