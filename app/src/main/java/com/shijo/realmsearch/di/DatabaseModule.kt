package com.shijo.realmsearch.di

import com.shijo.realmsearch.db.MyDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    /**
     *this method provide RealmConfiguration instance in application scope
     *
     * @return  the RealmConfiguration instance of the application
     **/
    @Provides
    @Singleton
    fun provideRealmConfig() : RealmConfiguration {
        return RealmConfiguration.Builder()
            .name("myrealm.realm")
            .schemaVersion(1)
            .build()
    }

    @Provides
    @Singleton
    fun provideRealm(realmConfiguration: RealmConfiguration) : Realm {
        Realm.setDefaultConfiguration(realmConfiguration)
        return  Realm.getDefaultInstance()
    }

    /**
     * this method provide instance of MyDb
     * */
    @Singleton
    @Provides
    fun providesMydb(realm: Realm) : MyDb {
        return MyDb(realm)
    }

}