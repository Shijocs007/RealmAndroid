package com.shijo.realmsearch.db

import com.shijo.realmsearch.models.Results
import io.realm.Realm

class MyDb(private val realm: Realm) {

    /**
     * This method insert all the result to the DB
     * @param results list of data parsed from data.json
     * */
    fun insertAllData(results: List<Results>) {
        realm.beginTransaction()
        realm.insertOrUpdate(results)
        realm.commitTransaction()
    }

    fun getAllSearchData(searckKeys : List<String>) : List<Results> {
        return realm.where(Results::class.java).findAll()
    }

}