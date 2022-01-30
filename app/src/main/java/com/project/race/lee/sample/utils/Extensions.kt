package com.project.race.lee.sample.utils

fun hourDisplayFormat(start: String?, end: String?): String {
    val startTime = if (start.isNullOrEmpty()) "Unknown" else start.toHour()
    val ensTime = if (end.isNullOrEmpty()) "Unknown" else end.toHour()
    return "Start:$startTime End:$ensTime"
}


fun String.toHour(): String {
    return StringBuffer(this).insert(this.length - 2, ":").toString()
}