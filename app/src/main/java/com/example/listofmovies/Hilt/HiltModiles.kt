package com.example.listofmovies.Hilt

import com.example.listofmovies.remote.MovieInterface
import com.example.listofmovies.ui.details.MovieDetailRepository
import com.example.listofmovies.ui.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module


object HiltModiles {



    @Provides
    fun provideRetrofitInterface(): MovieInterface {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }


    @Provides
    fun provideRepository(movieInterface: MovieInterface):MovieDetailRepository{
        return MovieDetailRepository(movieInterface)
    }
}