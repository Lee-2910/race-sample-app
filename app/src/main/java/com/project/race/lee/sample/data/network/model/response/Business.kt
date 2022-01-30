package com.project.race.lee.sample.data.network.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Business(
    val name: String,
    @Json(name = "image_url")
    val imageUrl: String,
    val categories: List<Categories>? = null,
    @Json(name = "hours")
    val hours: List<Hours>? = null,
    @Json(name = "display_phone")
    val displayPhone: String?,
    @Json(name = "location")
    val address: Location? = null,
    val rating: String? = null,
    @Json(name = "transactions")
    val transactions: List<String>? = null
) {
    @JsonClass(generateAdapter = true)
    data class Categories(
        val alias: String,
        val title: String
    )

    @JsonClass(generateAdapter = true)
    data class Hours(
        val open: List<Opens>? = null,
        @Json(name = "hours_type")
        val hoursType: String?= null,
        @Json(name = "is_open_now")
        val isOpenNow: Boolean? = null
    )

    @JsonClass(generateAdapter = true)
    data class Opens(
        @Json(name = "is_overnight")
        val isOvernight: Boolean? = null,
        val start: String? = null,
        val end: String? = null,
        val day: Int? = null
    )

    @JsonClass(generateAdapter = true)
    data class Location(
        @Json(name = "display_address")
        val displayAddress: List<String>? = null
    )
}