package com.shijo.realmsearch.di

import com.google.gson.Gson
import com.shijo.realmsearch.db.MyDb
import com.shijo.realmsearch.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ApplicationModule {

    @Provides
    @Singleton
    fun provideGSON() : Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideSearchRepository(myDb: MyDb) : SearchRepository {
        return SearchRepository((myDb))
    }
}