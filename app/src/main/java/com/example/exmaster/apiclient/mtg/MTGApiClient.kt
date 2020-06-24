package com.example.exmaster.apiclient.mtg

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MTGApiClient {
    private var instance: Retrofit? = null
    private val URL: String = "https://api.magicthegathering.io"
    private fun getInstance(): Retrofit{
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance as Retrofit
    }

    fun getDeckService(): MarvelCharacterService =
        getInstance().create(MarvelCharacterService::class.java)
}