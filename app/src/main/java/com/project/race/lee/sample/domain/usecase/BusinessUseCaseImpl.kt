package com.project.race.lee.sample.domain.usecase

import com.project.race.lee.sample.domain.model.BusinessModel
import com.project.race.lee.sample.domain.repository.BusinessRepository
import com.project.race.lee.sample.utils.DISTANCE
import com.project.race.lee.sample.utils.RATING
import com.project.race.lee.sample.utils.SearchType
import com.project.race.lee.sample.utils.SortType
import javax.inject.Inject

class BusinessUseCaseImpl @Inject constructor(
    private val repository: BusinessRepository
) : BusinessUseCase {
    override suspend fun getBusiness(
        @SearchType searchType: Int,
        @SortType sortType: Int,
        key: String,
        lat: Double?,
        long: Double?
    ): Result<List<BusinessModel>> {
        val sortBy = if (sortType == SortType.DISTANCE) DISTANCE else RATING
        val location = if (lat == null || long == null) "SF" else null
        return when (searchType) {
            SearchType.NAME -> repository.getBusiness(
                name = key,
                address = location,
                lat = lat,
                long = long,
                sortBy = sortBy
            )
            SearchType.ADDRESS -> repository.getBusiness(
                address = key,
                lat = lat,
                long = long,
                sortBy = sortBy
            )
            SearchType.CATEGORIES -> repository.getBusiness(
                categories = key,
                address = location,
                lat = lat,
                long = long,
                sortBy = sortBy
            )
            else -> repository.getBusiness(
                name = key,
                address = location,
                lat = lat,
                long = long,
                sortBy = sortBy
            )
        }

    }
}
