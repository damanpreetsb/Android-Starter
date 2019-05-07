package com.daman.starter

import android.app.Activity
import android.app.Application
import com.daman.starter.data.prefs.AppPreferences
import com.daman.starter.injection.component.AppComponent
import com.daman.starter.injection.component.DaggerAppComponent
import com.daman.starter.injection.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class AndroidStarterApplication : Application(), HasActivityInjector {
    companion object {
        lateinit var component: AppComponent
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initDI()
        initSharedPreferences()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDI() {
        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }

    private fun initSharedPreferences() = AppPreferences.init(this)

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}