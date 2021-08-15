package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StoreViewModel: ViewModel() {

    private var list = mutableListOf<Shoe>(Shoe("Zipflex", "8.5", "Ecco", "sneakers"),
        Shoe("Soft 7", "9", "Ecco", "sneakers"))

    //the list to store all added shoe items
    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList


    init {
       _shoesList.value = list
    }

}