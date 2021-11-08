package com.migue.gar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("miguel", "se ha creado la aplicacion")

    }

    override fun onStart() {
        super.onStart()
        Log.d("miguel", "la aplicación pasa a estar visble")
    }


    override fun onResume() {
        super.onResume()
        Log.d("miguel", "sale de estado invisible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("miguel", "se veuelve ha aplicar la aplicación")
    }
    override fun onStop() {
        super.onStop()
        Log.d("miguel", "la aplicación se ha parado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("miguel", "la aplicación ha deajdo de ejecutarse")
    }

}


