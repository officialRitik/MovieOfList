package com.example.listofmovies.remote

import com.example.listofmovies.data.MovieResponse
import com.example.listofmovies.data.moviedetails.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {


    @GET(" ")
    suspend fun getAllMovies(
        @Query("s")s:String,
        @Query("page")page:Int,
        @Query("apikey")apikey:String
    ):Response<MovieResponse>


    @GET(" ")
    suspend fun getMovieDetails(
        @Query("")imdbId:String,
        @Query("apikey")apikey:String
    ):Response<MovieDetails>
}