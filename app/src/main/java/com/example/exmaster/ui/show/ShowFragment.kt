package com.example.exmaster.ui.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.exmaster.MainViewModel
import com.example.exmaster.R
import kotlinx.android.synthetic.main.fragment_show.*

class ShowFragment : Fragment() {

    private lateinit var showViewModel: ShowViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        showViewModel =
                ViewModelProviders.of(this).get(ShowViewModel::class.java)
        activity?.let {
            mainViewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
        }
        val root = inflater.inflate(R.layout.fragment_show, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtVwHeroShowName.text = mainViewModel.character?.name
        txtVwHeroShowDescription.text = mainViewModel.character?.description
    }
}
