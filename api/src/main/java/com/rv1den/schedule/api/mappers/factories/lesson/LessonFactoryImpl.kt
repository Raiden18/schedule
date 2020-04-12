package com.rv1den.schedule.api.mappers.factories.lesson

import com.rv1den.schedule.api.jsons.LessonJsonScheme
import com.rv1den.schedule.domain.models.values.Number
import com.rv1den.schedule.domain.models.values.lesson.*

class LessonFactoryImpl : LessonFactory {
    override fun create(lessonJsonScheme: LessonJsonScheme): Lesson {
        val lessonName = LessonName(lessonJsonScheme.lessonName)
        val teacherName = TeacherName(lessonJsonScheme.teacherName)
        val auditory = Auditory(lessonJsonScheme.auditory)
        val lessonDuration = LessonDuration(lessonJsonScheme.timeFrom, lessonJsonScheme.timeTo)
        val type = LessonType(lessonJsonScheme.type)
        val lessonNumber = Number(lessonJsonScheme.lessonNumber)
        return Lesson(
            lessonName,
            teacherName,
            auditory,
            lessonDuration,
            type,
            lessonNumber
        )
    }
}