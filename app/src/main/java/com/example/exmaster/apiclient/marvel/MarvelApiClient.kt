package com.example.exmaster.apiclient.mtg

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApiClient {
    private var instance: Retrofit? = null
    private val URL: String = "https://gateway.marvel.com/"
    private fun getInstance(): Retrofit{
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance as Retrofit
    }

    fun getMarvelCharacterService(): MarvelCharacterService =
        getInstance().create(MarvelCharacterService::class.java)
}