package com.example.exmaster.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.exmaster.MainViewModel
import com.example.exmaster.R
import com.example.exmaster.apiclient.mtg.model.Character
import kotlinx.android.synthetic.main.fragment_home.*

class ListFragment : Fragment() {

    private lateinit var listViewModel: ListViewModel
    private lateinit var mainViewModel: MainViewModel
    private var offsetPosition = 0
    private var limit = 10

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        listViewModel =
                ViewModelProviders.of(this).get(ListViewModel::class.java)
        activity?.let {
            mainViewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
        }
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel.setupRecycler(
            rcyVwCards,
            requireContext(),
            pgrBarListCards,
            this::recyclerClickListener
        )

        imgBtnSerachHero.setOnClickListener {
            val heroName = edtTxtHeroName.text.toString()
            if (!heroName.isNullOrEmpty()) {
                listViewModel.setupRecycler(
                    rcyVwCards,
                    requireContext(),
                    pgrBarListCards,
                    this::recyclerClickListener,
                    0,
                    heroName
                )
            } else {
                Toast.makeText(
                    context,
                    "Informe o nome de um Heroi.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        fabHerosNext.setOnClickListener {
            offsetPosition+=limit
            listViewModel.setupRecycler(
                rcyVwCards,
                requireContext(),
                pgrBarListCards,
                this::recyclerClickListener,
                offsetPosition
            )
        }
        fabHerosPrevious.setOnClickListener {
            if (offsetPosition - limit >= 0 ) {
                offsetPosition-=limit
                listViewModel.setupRecycler(
                    rcyVwCards,
                    requireContext(),
                    pgrBarListCards,
                    this::recyclerClickListener,
                    offsetPosition
                )
            } else {
                Toast.makeText(
                    context,
                    "Início da Lista.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun recyclerClickListener(character: Character){
        mainViewModel.character = character
        findNavController().navigate(R.id.navigation_dashboard)
    }
}
