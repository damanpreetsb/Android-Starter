package com.daman.starter.injection.component

import com.daman.starter.AndroidStarterApplication
import com.daman.starter.injection.module.ActivityModule
import com.daman.starter.injection.module.AppModule
import com.daman.starter.injection.module.NetworkModule
import com.daman.starter.injection.module.ViewModelModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ViewModelModule::class,
    ActivityModule::class])
interface AppComponent {

    fun inject(application: AndroidStarterApplication)

}