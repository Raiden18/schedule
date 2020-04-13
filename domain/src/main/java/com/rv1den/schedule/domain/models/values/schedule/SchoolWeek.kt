package com.rv1den.schedule.domain.models.values.schedule

import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.models.values.lesson.Lesson

data class SchoolWeek(
    val monday: SchoolDay,
    val tuesday: SchoolDay,
    val wednesday: SchoolDay,
    val thursday: SchoolDay,
    val friday: SchoolDay,
    val saturday: SchoolDay
) {

    companion object {
        private const val MONDAY_DAY_NUMBER = 1
        private const val TUESDAY_DAY_NUMBER = 2
        private const val WEDNESDAY_DAY_NUMBER = 3
        private const val THURSDAY_DAY_NUMBER = 4
        private const val FRIDAY_DAY_NUMBER = 5
        private const val SATURDAY_DAY_NUMBER = 6

        fun createEmpty() = SchoolWeek(
            SchoolDay.noLessons(MONDAY_DAY_NUMBER),
            SchoolDay.noLessons(TUESDAY_DAY_NUMBER),
            SchoolDay.noLessons(WEDNESDAY_DAY_NUMBER),
            SchoolDay.noLessons(THURSDAY_DAY_NUMBER),
            SchoolDay.noLessons(FRIDAY_DAY_NUMBER),
            SchoolDay.noLessons(SATURDAY_DAY_NUMBER)
        )

        fun createEmptyMonday() = SchoolDay.noLessons(MONDAY_DAY_NUMBER)
        fun createEmptyTuesday() = SchoolDay.noLessons(TUESDAY_DAY_NUMBER)
        fun createEmptyWednesday() = SchoolDay.noLessons(WEDNESDAY_DAY_NUMBER)
        fun createEmptyThursday() = SchoolDay.noLessons(THURSDAY_DAY_NUMBER)
        fun createEmptyFriday() = SchoolDay.noLessons(FRIDAY_DAY_NUMBER)
        fun createEmptySaturday() = SchoolDay.noLessons(SATURDAY_DAY_NUMBER)
    }

    fun isEmpty() = monday.isNoLessons
            && tuesday.isNoLessons
            && wednesday.isNoLessons
            && thursday.isNoLessons
            && friday.isNoLessons
            && saturday.isNoLessons

    fun getDayFor(schoolLesson: Lesson): SchoolDay {
        return when {
            monday.contains(schoolLesson) -> monday
            tuesday.contains(schoolLesson) -> tuesday
            wednesday.contains(schoolLesson) -> wednesday
            thursday.contains(schoolLesson) -> thursday
            friday.contains(schoolLesson) -> friday
            saturday.contains(schoolLesson) -> saturday
            else -> throw IllegalStateException("There is no day for that lesson")
        }
    }

    fun contains(schoolLesson: Lesson): Boolean {
        return monday.contains(schoolLesson)
                || tuesday.contains(schoolLesson)
                || wednesday.contains(schoolLesson)
                || thursday.contains(schoolLesson)
                || friday.contains(schoolLesson)
                || saturday.contains(schoolLesson)
    }

    override fun toString(): String {
        return "monday: $monday \n" +
                "tuesday: $tuesday \n" +
                "wednesday: $wednesday \n" +
                "thursday: $thursday \n" +
                "friday: $friday \n" +
                "saturday: $saturday \n"
    }
}