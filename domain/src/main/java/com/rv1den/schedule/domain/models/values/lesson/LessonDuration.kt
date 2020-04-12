package com.rv1den.schedule.domain.models.values.lesson

data class LessonDuration(
    val timeFrom: String,
    val timeTo: String
){
    companion object {
        fun createEmpty() = LessonDuration("", "")
    }

    fun isEmpty() = timeFrom.isEmpty() && timeTo.isEmpty()
}