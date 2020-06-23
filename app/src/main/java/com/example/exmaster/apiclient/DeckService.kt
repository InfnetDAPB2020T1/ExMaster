package com.example.exmaster.apiclient

import com.example.exmaster.apiclient.model.Card
import com.example.exmaster.apiclient.model.CardResponse
import com.example.exmaster.apiclient.model.Deck
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DeckService {

    @GET("v1/cards")
    fun all(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10): Call<Deck> // {}

    @GET("v1/cards/{id}")
    fun show(@Path("id") id: String): Call<CardResponse>
}