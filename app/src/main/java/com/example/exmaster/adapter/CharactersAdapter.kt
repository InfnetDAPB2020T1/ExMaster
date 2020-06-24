package com.example.exmaster.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exmaster.R
import com.example.exmaster.apiclient.mtg.model.Character
import kotlinx.android.synthetic.main.character_recycler_item.view.*

class CharactersAdapter (
    var characters: MutableList<Character>
) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>()
{
    class CharacterViewHolder(itemView: View) // layout XML
        : RecyclerView.ViewHolder(itemView){
        val txtVwName: TextView = itemView.txtVwHeroName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : CharacterViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.character_recycler_item,
                parent,
                false
            )
        val cardsViewHolder = CharacterViewHolder(view)
        return cardsViewHolder
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.txtVwName.text = character.name

    }
}