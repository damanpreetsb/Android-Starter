package com.daman.starter.injection.module

import com.daman.starter.injection.scope.ActivityScope
import com.daman.starter.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}
