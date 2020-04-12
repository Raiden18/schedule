package com.rv1den.schedule.domain.models.values.lesson

data class LessonType(val value: String){
    companion object{
        fun createEmpty() = LessonType("")
    }

    fun isEmpty() = value.isEmpty()
}