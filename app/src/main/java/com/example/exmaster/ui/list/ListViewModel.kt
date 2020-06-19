package com.example.exmaster.ui.list

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.exmaster.adapter.CardsAdapter
import com.example.exmaster.apiclient.ApiClient
import com.example.exmaster.apiclient.model.Deck
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {

    fun setupRecycler(
        recyclerView: RecyclerView,
        context: Context
    ){
        // Chamar a API
        val call = ApiClient.getDeckService().all()
        call.enqueue(object : Callback<Deck> {
            override fun onFailure(call: Call<Deck>, t: Throwable) {
                Toast.makeText(
                    context, t.message, Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(call: Call<Deck>, response: Response<Deck>) {
                val deck = response.body()
                if (deck != null && !deck.cards.isNullOrEmpty()){
                    recyclerView.adapter = CardsAdapter(deck.cards!!.toMutableList())
                } else {
                    Toast.makeText(
                        context, "Não foi encontrado nenhum card.", Toast.LENGTH_LONG
                    ).show()
                }
            }

        })
        // se tem retorno montar a Recycler
        // se não, notificar o usuario
    }
}