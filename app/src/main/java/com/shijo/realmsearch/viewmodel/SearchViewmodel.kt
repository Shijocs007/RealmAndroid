package com.shijo.realmsearch.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.shijo.realmsearch.models.Results
import com.shijo.realmsearch.repository.SearchRepository

class SearchViewmodel
@ViewModelInject
constructor(private val repository: SearchRepository,
    @Assisted savedStateHandle: SavedStateHandle) : ViewModel() {

    var searchLiveData = MutableLiveData<List<Results>>()
    var searchKeys = ArrayList<String>()

    fun searchData()  {
        searchLiveData.value = repository.getAllSearchData(searchKeys)
    }

    fun getSearchLivedata() : LiveData<List<Results>> {
        return searchLiveData
    }
}

