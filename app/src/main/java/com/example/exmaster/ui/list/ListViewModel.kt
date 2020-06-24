package com.example.exmaster.ui.list

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exmaster.MainViewModel
import com.example.exmaster.adapter.CardsAdapter
import com.example.exmaster.adapter.CharactersAdapter
import com.example.exmaster.apiclient.mtg.MarvelApiClient
import com.example.exmaster.apiclient.mtg.model.Character
import com.example.exmaster.apiclient.mtg.model.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {

    fun setupRecycler(
        recyclerView: RecyclerView,
        context: Context,
        pgrBarListCards: ProgressBar,
        callback: (Character) -> Unit,
        offset: Int = 0,
        heroName: String? = null
    ){
//        pgrBarListCards.visibility = View.VISIBLE
        val call = if (heroName != null)
            MarvelApiClient.getMarvelCharacterService().showByName(heroName, offset)
            else MarvelApiClient.getMarvelCharacterService().all(offset)

        call.enqueue(object : Callback<CharacterResponse> {
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
//                pgrBarListCards.visibility = View.GONE
                Toast.makeText(
                    context, t.message, Toast.LENGTH_LONG
                ).show()
            }
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                val characterResponse = response.body()
                if (
                    characterResponse != null
                    && !characterResponse.data?.results.isNullOrEmpty()){
                    recyclerView.adapter =
                        CharactersAdapter(
                            characterResponse.data?.results!!.toMutableList(),
                            callback
                        )
                    recyclerView.layoutManager = LinearLayoutManager(context)
                } else {
                    Toast.makeText(
                        context, "Não foi encontrado nenhum Herói.", Toast.LENGTH_LONG
                    ).show()
                }
//                pgrBarListCards.visibility = View.GONE
            }
        })
    }
}