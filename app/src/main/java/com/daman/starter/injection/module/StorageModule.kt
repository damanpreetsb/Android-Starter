package com.daman.starter.injection.module

import com.daman.starter.data.api.ApiInterface
import com.daman.starter.data.repository.AppRepository
import com.daman.starter.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {
    @Provides
    @Singleton
    fun providesAppRepositoryImpl(apiInterface: ApiInterface): AppRepository {
        return MainRepository(apiInterface)
    }
}
