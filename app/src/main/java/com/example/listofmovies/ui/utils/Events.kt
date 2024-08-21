package com.example.listofmovies.ui.utils

class Events<out T>(private val content : T) {

    var hasBeenHandler = false

    fun getContentIfNotHandled():T? {
        return if (!hasBeenHandler){
            hasBeenHandler = true
            content
        }else{
            null
        }
    }
    fun peekContent():T = content
}