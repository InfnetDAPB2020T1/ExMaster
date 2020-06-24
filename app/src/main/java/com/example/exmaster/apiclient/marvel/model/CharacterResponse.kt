package com.example.exmaster.apiclient.mtg.model

class CharacterResponse (
    var code: Int? = null,
    var status: String? = null,
    var data: Data? = null
){
    inner class Data(
        val offset: Int? = null,
        val limit: Int? = null,
        val total: Int? = null,
        val count: Int? = null,
        var results: List<Character>
    )
}