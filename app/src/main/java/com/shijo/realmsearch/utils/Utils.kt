package com.shijo.realmsearch.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shijo.realmsearch.models.Results
import java.io.IOException

object Utils {

    fun parseJsonData(context: Context, gson: Gson) : List<Results>? {
        var jsonString = ""
        try {
            jsonString = context.assets.open("data.json").bufferedReader().use { it.readText() }
            val resultType = object : TypeToken<List<Results>>() {}.type
            var results: List<Results> = gson.fromJson(jsonString, resultType)
            return results;
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return null
    }
}