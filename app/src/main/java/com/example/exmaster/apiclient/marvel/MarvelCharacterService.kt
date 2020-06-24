package com.example.exmaster.apiclient.mtg

import com.example.exmaster.apiclient.mtg.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelCharacterService {

    @GET("v1/public/characters")
    fun all(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 10,
        @Query("apikey") apikey: String
        = "cf58b8d0b024f8fdd3230a4e51075e92",
        @Query("ts") ts: Long = 1000L,
        @Query("hash") hash: String
        = "70c554f690db22dc6a4f4e76a54b4955"
    ): Call<CharacterResponse>

    @GET("v1/public/characters")
    fun showByName(
        @Query("name") name: String,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 10,
        @Query("apikey") apikey: String
        = "cf58b8d0b024f8fdd3230a4e51075e92",
        @Query("ts") ts: Long = 1000L,
        @Query("hash") hash: String
        = "70c554f690db22dc6a4f4e76a54b4955"
    ): Call<CharacterResponse>

    @GET("v1/public/characters/{characterId}")
    fun show(
        @Path("characterId") id: Int,
        @Query("apikey") apikey: String
        = "cf58b8d0b024f8fdd3230a4e51075e92",
        @Query("ts") ts: Long = 1000L,
        @Query("hash") hash: String
        = "70c554f690db22dc6a4f4e76a54b4955"
    ): Call<CharacterResponse>
}