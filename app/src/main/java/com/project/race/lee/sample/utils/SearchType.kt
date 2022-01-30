package com.project.race.lee.sample.utils

import androidx.annotation.IntDef
import com.project.race.lee.sample.utils.SearchType.Companion.ADDRESS
import com.project.race.lee.sample.utils.SearchType.Companion.CATEGORIES
import com.project.race.lee.sample.utils.SearchType.Companion.NAME

@IntDef(value = [NAME, ADDRESS, CATEGORIES])
@Retention(AnnotationRetention.SOURCE)
annotation class SearchType {
    companion object {
        const val NAME = 0 // Search by business name
        const val ADDRESS = 1 // Search by address/city/postal code
        const val CATEGORIES = 2 // Search by cuisine type
    }
}
