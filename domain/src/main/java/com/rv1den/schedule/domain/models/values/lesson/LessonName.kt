package com.rv1den.schedule.domain.models.values.lesson

data class LessonName(val value: String) {
    companion object {
        fun createEmpty() = LessonName("")
    }

    fun isEmpty() = value.isEmpty()
}