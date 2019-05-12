package com.daman.starter.injection.module

import android.content.Context
import android.content.SharedPreferences
import com.daman.starter.AndroidStarterApplication
import com.daman.starter.data.prefs.AppPreferences
import com.daman.starter.data.prefs.AppSettings
import com.daman.starter.utils.PREF_SHARED_PREFS_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: AndroidStarterApplication) {

    @Provides
    @Singleton
    fun provideAndroidStarterApp(): AndroidStarterApplication = app

    @Provides
    @Singleton
    fun providesSharedPreferences(context: AndroidStarterApplication): AppSettings =
        AppPreferences(context.getSharedPreferences(PREF_SHARED_PREFS_NAME, Context.MODE_PRIVATE))
}