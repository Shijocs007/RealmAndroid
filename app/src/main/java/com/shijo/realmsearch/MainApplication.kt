package com.shijo.realmsearch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm


/**
 * This class is the application class for the project
 * <b>Notes:</b>
 * <ol>
 * <li> <b>@HiltAndroidApp</b> anootation is part of Dagger-Hilt </li>
 * </ol>
 */
@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext);
    }
}