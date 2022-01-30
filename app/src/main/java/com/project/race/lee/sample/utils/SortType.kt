package com.project.race.lee.sample.utils

import androidx.annotation.IntDef
import com.project.race.lee.sample.utils.SortType.Companion.DISTANCE
import com.project.race.lee.sample.utils.SortType.Companion.RATINGS

@IntDef(value = [DISTANCE, RATINGS])
@Retention(AnnotationRetention.SOURCE)
annotation class SortType {
    companion object {
        const val DISTANCE = 0 // Sorting of results by distance
        const val RATINGS = 1 // Sorting of results by ratings
    }
}
