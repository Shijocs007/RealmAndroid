package com.shijo.realmsearch.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.shijo.realmsearch.R
import com.shijo.realmsearch.db.MyDb
import com.shijo.realmsearch.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    val activityScope = CoroutineScope(Dispatchers.Main)
    @Inject
    lateinit var myDb: MyDb

    @Inject
    lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        activityScope.launch {
            delay(3000)
            insertDataToDb()
        }
    }

    /**
     * this method used to parse json into results and
     * insert it into DB
     * */
    private fun insertDataToDb() {
        Utils.parseJsonData(this, gson).let {
            it?.let { it1 -> myDb.insertAllData(it1) }
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}