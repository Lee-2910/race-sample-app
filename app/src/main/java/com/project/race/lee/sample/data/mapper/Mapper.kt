package com.project.race.lee.sample.data.mapper

interface Mapper<I, O> {

    fun map(input: I): O
}
