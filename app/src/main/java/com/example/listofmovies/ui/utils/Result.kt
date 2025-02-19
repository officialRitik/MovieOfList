package com.example.listofmovies.utils

import androidx.core.app.NotificationCompat.MessagingStyle.Message
import androidx.lifecycle.ComputableLiveData
import com.example.listofmovies.utils.Status
import com.example.listofmovies.utils.Result

class Result<out T >(val status: Status, val data:T?,message: String?) {



    companion object{
        fun <T> success(data: T?): Result <T> {
            return Result(Status.SUCCESS, data,null)
        }

        fun <T>loading(message: String?): Result <T> {
            return Result(Status. LOADING,null , message)
        }
        fun <T> error (message: String?): Result<T> {
           return Result(Status.ERROR,null , message)
        }
    }
}
enum class Status{
    SUCCESS,
    LOADING,
    ERROR
}

