package com.example.listofmovies.ui.details

import com.example.listofmovies.data.moviedetails.MovieDetails
import com.example.listofmovies.remote.MovieInterface
import com.example.listofmovies.ui.utils.Constants
import com.example.listofmovies.utils.Status
import com.example.listofmovies.utils.Result
import java.lang.Exception


class MovieDetailRepository(private val movieInterface: MovieInterface) {


    suspend fun getMovieDetails(imdbId:String):Result<MovieDetails>{


        return try {
            val response = movieInterface.getMovieDetails(imdbId,Constants.API_KEY)
            if (response.isSuccessful){


                Result(Status.SUCCESS, response.body(),null)
            } else{
                Result(Status.ERROR, null, null)
            }

        }catch (e:Exception){
            Result(Status.ERROR,null,null)
        }
    }



}