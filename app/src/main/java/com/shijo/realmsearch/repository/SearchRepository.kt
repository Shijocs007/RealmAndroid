package com.shijo.realmsearch.repository

import com.shijo.realmsearch.db.MyDb

class SearchRepository(private val myDb: MyDb) {

    suspend fun getAllSearchData(searchKeys : List<String>) = myDb.getAllSearchData(searchKeys)
}