package com.damaris.jugando.model

class ModelMensajes {

    private var mensajes: MutableList<String> = mutableListOf()

    fun addMensaje(msj: String){
        mensajes.add(msj)
    }

    fun getMensajes(): MutableList<String>{
        return mensajes
    }

}