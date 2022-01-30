package com.project.race.lee.sample.domain.repository

import com.project.race.lee.sample.domain.model.BusinessModel


interface BusinessRepository {
    suspend fun getBusiness(
        name: String? = null,
        categories: String? = null,
        address: String? = null,
        lat: Double?,
        long: Double?,
        sortBy: String? = null
    ): Result<List<BusinessModel>>
}
