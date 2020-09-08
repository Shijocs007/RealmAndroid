package com.shijo.realmsearch.di

import com.google.gson.Gson
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
}