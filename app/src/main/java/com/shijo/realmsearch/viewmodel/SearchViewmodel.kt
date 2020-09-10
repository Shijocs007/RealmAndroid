package com.shijo.realmsearch.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.shijo.realmsearch.Coroutines
import com.shijo.realmsearch.models.Results
import com.shijo.realmsearch.repository.SearchRepository

class SearchViewmodel
@ViewModelInject
constructor(private val repository: SearchRepository,
    @Assisted savedStateHandle: SavedStateHandle) : ViewModel() {

    var searchLiveData = MutableLiveData<List<Results>>()
    var searchKeys = ArrayList<String>()

    fun searchData(key : String, isAdd : Boolean)  {

        if(isAdd) {
            searchKeys.add(key)
        } else {
            searchKeys.remove(key)
        }
        if(searchKeys.isNullOrEmpty()) {
            return
        }
        Coroutines.main {
            searchLiveData.value = repository.getAllSearchData(searchKeys)
        }
    }

    fun getSearchLivedata() : LiveData<List<Results>> {
        return searchLiveData
    }
}

