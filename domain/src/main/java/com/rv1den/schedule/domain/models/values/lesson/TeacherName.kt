package com.rv1den.schedule.domain.models.values.lesson

data class TeacherName(val value: String) {
    companion object {
        fun createEmpty() = TeacherName("")
    }

    fun isEmpty() = value.isEmpty()
}