package com.damaris.jugando.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.damaris.jugando.R
import com.damaris.jugando.viewmodel.ViewModelMensajes
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inicializamos los 3 componentes de la View
        val inputMensaje = findViewById<TextInputEditText>(R.id.inputMensaje)
        val enviarMensaje = findViewById<Button>(R.id.enviarMensaje)
        val mostrarMensajes = findViewById<TextView>(R.id.mostrarMensajes)

        // inicializamos el ViewModel
        val messageViewModel = ViewModelMensajes()

        // guardar mensaje en la lista
        enviarMensaje.setOnClickListener {
            val msj = inputMensaje.text.toString()
            messageViewModel.addMensaje(msj)
            inputMensaje.text?.clear()
        }

        // mostrar los mensajes de la lista a medida que se actualizan
        messageViewModel.mensajesLiveData.observe(this, Observer { mensajes ->
            mostrarMensajes.text = mensajes.joinToString("\n")
        })

    }
}