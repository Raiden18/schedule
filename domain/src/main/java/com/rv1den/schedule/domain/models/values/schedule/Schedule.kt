package com.rv1den.schedule.domain.models.values.schedule

import com.rv1den.schedule.domain.models.values.lesson.Lesson

data class Schedule(
    val oddSchoolWeek: SchoolWeek,
    val evenSchoolWeek: SchoolWeek
) {
    companion object {
        fun createEmpty() =
            Schedule(
                SchoolWeek.createEmpty(),
                SchoolWeek.createEmpty()
            )
    }

    fun getWeekFor(schoolLesson: Lesson): SchoolWeek {
        return when {
            oddSchoolWeek.contains(schoolLesson) -> oddSchoolWeek
            evenSchoolWeek.contains(schoolLesson) -> evenSchoolWeek
            else -> throw IllegalStateException("There is no such week for that lesson")
        }
    }

    fun isEmpty(): Boolean {
        return oddSchoolWeek.isEmpty() && evenSchoolWeek.isEmpty()
    }


    override fun toString(): String {
        return "Odd: $oddSchoolWeek  Even: $evenSchoolWeek"
    }

}