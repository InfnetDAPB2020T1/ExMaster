package com.example.exmaster

import androidx.lifecycle.ViewModel
import com.example.exmaster.apiclient.mtg.model.Character

class MainViewModel : ViewModel() {
    var character : Character? = null
}