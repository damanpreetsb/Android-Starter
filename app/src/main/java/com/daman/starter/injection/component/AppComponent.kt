package com.daman.starter.injection.component

import com.daman.starter.AndroidStarterApplication
import com.daman.starter.injection.module.*
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    StorageModule::class,
    ViewModelModule::class
])
interface AppComponent {
    fun inject(application: AndroidStarterApplication)
}
