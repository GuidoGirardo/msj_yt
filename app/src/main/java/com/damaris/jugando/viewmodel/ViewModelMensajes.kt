package com.damaris.jugando.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.damaris.jugando.model.ModelMensajes

class ViewModelMensajes: ViewModel() {

    private val modelMensajes = ModelMensajes()

    private val _mensajesLiveData = MutableLiveData<List<String>>()
    val mensajesLiveData: LiveData<List<String>> get() = _mensajesLiveData

    fun addMensaje(msj: String){
        modelMensajes.addMensaje(msj)
        _mensajesLiveData.value = modelMensajes.getMensajes()
    }

}