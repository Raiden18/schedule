package com.rv1den.schedule.api.mappers

interface Mapper<R, D> {
    fun  map(response: R): D
}