package com.project.race.lee.sample.data.network

import com.project.race.lee.sample.data.network.model.response.BusinessSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BusinessNetworkService {
    @GET("v3/businesses/search")
    suspend fun search(
        @Query("term") term: String?,
        @Query("categories") categories: String?,
        @Query("location") address: String?,
        @Query("latitude") lat: Double?,
        @Query("longitude") long: Double?,
        @Query("sort_by") sortBy: String?
    ): BusinessSearchResponse?
}
