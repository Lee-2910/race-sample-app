package com.project.race.lee.sample.di

import com.project.race.lee.sample.data.network.BusinessNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BusinessProviderModule {

    @Provides
    @Singleton
    fun providesBusinessNetworkService(retrofit: Retrofit): BusinessNetworkService {
        return retrofit.create(BusinessNetworkService::class.java)
    }
}
