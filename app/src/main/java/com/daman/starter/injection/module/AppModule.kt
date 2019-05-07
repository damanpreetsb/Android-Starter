package com.daman.starter.injection.module

import com.daman.starter.AndroidStarterApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: AndroidStarterApplication) {

    @Provides
    @Singleton
    fun provideAndroidStarterApp() = app
}