package com.shijo.realmsearch.db

import com.shijo.realmsearch.models.Results
import io.realm.Case
import io.realm.Realm
import io.realm.kotlin.where

class MyDb(private val realm: Realm) {

    /**
     * This method insert all the result to the DB
     * @param results list of data parsed from data.json
     * */
    fun insertAllData(results: List<Results>) {
        realm.beginTransaction()
        realm.deleteAll()
        realm.insertOrUpdate(results)
        realm.commitTransaction()
    }

    suspend fun getAllSearchData(searckKeys : List<String>) : List<Results> {
        val query  = realm.where<Results>()
        for (key in searckKeys) {
            query.contains("units.title", key, Case.INSENSITIVE)
            query.contains("units.activities.activity_name", key, Case.INSENSITIVE)
            query.contains("units.activities.step_name", key, Case.INSENSITIVE)
        }
        return query.findAll()
    }

}