package com.rv1den.schedule.domain.models.values.lesson

import com.rv1den.schedule.domain.models.values.Number

data class Lesson(
    val lessonName: LessonName,
    val teacherName: TeacherName,
    val auditory: Auditory,
    val lessonDuration: LessonDuration,
    val type: LessonType,
    val number: Number
) {
    companion object {
        fun createEmpty() = Lesson(
            LessonName.createEmpty(),
            TeacherName.createEmpty(),
            Auditory.createEmpty(),
            LessonDuration.createEmpty(),
            LessonType.createEmpty(),
            Number.createEmpty()
        )
    }

    fun isEmpty() = lessonName.isEmpty()
            && teacherName.isEmpty()
            && auditory.isEmpty()
            && lessonDuration.isEmpty()
            && type.isEmpty()
            && number.isEmpty()

}