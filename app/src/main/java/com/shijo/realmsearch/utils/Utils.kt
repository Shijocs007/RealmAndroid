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

    fun getHtmleString(keys : List<String>) : String {
        var text = ""
        if(keys.isNullOrEmpty()) {
            text = "type start searching for <br> <font color = #FFCE32> Units, Activities, Status</font>"
        } else {
            text = "Terms(s) "
            for (key in keys) {
                text = "$text <font color = #FFCE32>$key</font>,"
            }

            text = "$text not found"
        }
        return text
    }
}