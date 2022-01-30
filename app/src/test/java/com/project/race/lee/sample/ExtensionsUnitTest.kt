package com.project.race.lee.sample

import com.project.race.lee.sample.utils.hourDisplayFormat
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExtensionsUnitTest {
    @Test
    fun checkFormatHours() {
       val hours = hourDisplayFormat("2000", "0915")
        assertEquals("Start:20:00 End:09:15", hours)
    }
}