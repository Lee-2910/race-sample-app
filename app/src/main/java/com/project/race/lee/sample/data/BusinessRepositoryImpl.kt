package com.project.race.lee.sample.data

import com.project.race.lee.sample.data.mapper.BusinessResponseMapper
import com.project.race.lee.sample.data.network.BusinessNetworkService
import com.project.race.lee.sample.domain.model.BusinessModel
import com.project.race.lee.sample.domain.repository.BusinessRepository
import javax.inject.Inject

class BusinessRepositoryImpl @Inject constructor(
    private val businessNetworkService: BusinessNetworkService,
    private val businessMapperHolder: BusinessResponseMapper,
) : BusinessRepository {

    override suspend fun getBusiness(
        name: String?,
        categories: String?,
        address: String?,
        lat: Double?,
        long: Double?,
        sortBy: String?
    ): Result<List<BusinessModel>> {
        try {
            businessNetworkService.search(name, categories, address, lat, long, sortBy)?.let {
                return Result.success(
                    value = businessMapperHolder.map(
                        input = it
                    ).business
                )
            } ?: kotlin.run {
                return Result.failure(exception = Throwable(message = "There is a server error, please try again later!"))
            }
        } catch (ex: Exception) {
            return Result.failure(exception = ex)
        }
    }
}
