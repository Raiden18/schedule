package com.rv1den.schedule.domain.models.values.day

import com.rv1den.schedule.domain.models.values.Number
import com.rv1den.schedule.domain.models.values.lesson.Lesson

data class SchoolDay(
    val firstLesson: Lesson,
    val secondLesson: Lesson,
    val thirdLesson: Lesson,
    val fourthLesson: Lesson,
    val fifthLesson: Lesson,
    val number: Number
) {
    companion object {
        fun noLessons(number: Int) = SchoolDay(
            Lesson.createEmpty(),
            Lesson.createEmpty(),
            Lesson.createEmpty(),
            Lesson.createEmpty(),
            Lesson.createEmpty(),
            Number(number)
        )
    }

    val isNoLessons: Boolean
        get() = firstLesson.isEmpty()
                && secondLesson.isEmpty()
                && thirdLesson.isEmpty()
                && fourthLesson.isEmpty()
                && fifthLesson.isEmpty()
}