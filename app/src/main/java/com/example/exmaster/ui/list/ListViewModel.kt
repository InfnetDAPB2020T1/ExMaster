package com.example.exmaster.ui.list

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.exmaster.adapter.CardsAdapter
import com.example.exmaster.apiclient.ApiClient
import com.example.exmaster.apiclient.model.Deck
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {

    fun setupRecycler(
        recyclerView: RecyclerView,
        context: Context,
        pgrBarListCards: ProgressBar
    ){
        // Chamar a API
        pgrBarListCards.visibility = View.VISIBLE
        val call = ApiClient.getDeckService().all()
        call.enqueue(object : Callback<Deck> {
            override fun onFailure(call: Call<Deck>, t: Throwable) {
                pgrBarListCards.visibility = View.GONE
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
                pgrBarListCards.visibility = View.GONE
            }
        })
    }
}