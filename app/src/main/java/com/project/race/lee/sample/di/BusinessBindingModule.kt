package com.project.race.lee.sample.di

import com.project.race.lee.sample.data.BusinessRepositoryImpl
import com.project.race.lee.sample.data.mapper.BusinessResponseMapper
import com.project.race.lee.sample.data.mapper.Mapper
import com.project.race.lee.sample.data.network.model.response.BusinessSearchResponse
import com.project.race.lee.sample.domain.model.BusinessListModel
import com.project.race.lee.sample.domain.repository.BusinessRepository
import com.project.race.lee.sample.domain.usecase.BusinessUseCase
import com.project.race.lee.sample.domain.usecase.BusinessUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BusinessBindingModule {

    @Binds
    abstract fun bindBusinessUseCase(useCaseImpl: BusinessUseCaseImpl): BusinessUseCase

    @Binds
    abstract fun bindBusinessRepository(
        businessRepositoryImpl: BusinessRepositoryImpl
    ): BusinessRepository

    @Binds
    abstract fun bindsBusinessResponseMapper(
        businessRequestMapper: BusinessResponseMapper
    ): Mapper<BusinessSearchResponse, BusinessListModel>
}
