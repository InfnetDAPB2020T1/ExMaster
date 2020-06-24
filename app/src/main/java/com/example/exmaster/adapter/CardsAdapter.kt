package com.example.exmaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exmaster.R
import com.example.exmaster.apiclient.mtg.model.Character
import kotlinx.android.synthetic.main.card_recycler_item.view.*

class CardsAdapter (
    var cards: MutableList<Character>
) : RecyclerView.Adapter<CardsAdapter.CardsViewHolder>()
{
    class CardsViewHolder(itemView: View) // layout XML
        : RecyclerView.ViewHolder(itemView){
        val txtVwName: TextView = itemView.txtVwName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : CardsViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.card_recycler_item,
                parent,
                false
            )
        val cardsViewHolder = CardsViewHolder(view)
        return cardsViewHolder
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val card = cards[position]
        holder.txtVwName.text = card.name

    }
}