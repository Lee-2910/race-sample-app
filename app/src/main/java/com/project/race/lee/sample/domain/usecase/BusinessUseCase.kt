package com.project.race.lee.sample.domain.usecase

import com.project.race.lee.sample.domain.model.BusinessModel
import com.project.race.lee.sample.utils.SearchType
import com.project.race.lee.sample.utils.SortType

interface BusinessUseCase {

    suspend fun getBusiness(
        @SearchType searchType: Int,
        @SortType sortType: Int,
        key: String,
        lat: Double?,
        long: Double?
    ): Result<List<BusinessModel>>
}
