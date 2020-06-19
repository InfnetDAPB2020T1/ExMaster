package com.example.exmaster.apiclient

import com.example.exmaster.apiclient.model.Card
import com.example.exmaster.apiclient.model.CardResponse
import com.example.exmaster.apiclient.model.Deck
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DeckService {

    @GET("v1/cards")
    fun all(): Call<Deck> // {}

    @GET("v1/cards/{id}")
    fun show(@Path("id") id: String): Call<CardResponse>
}