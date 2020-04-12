package com.rv1den.schedule.api.mappers.lesson

import com.rv1den.schedule.api.jsons.LessonJsonScheme
import com.rv1den.schedule.api.mappers.lesson.factory.LessonFactory
import com.rv1den.schedule.domain.models.values.lesson.Lesson

class LessonResponseMapperImpl(
    private val lessonFactory: LessonFactory
) : LessonResponseMapper {
    override fun map(lessonJsonScheme: LessonJsonScheme?): Lesson {
        return if (lessonJsonScheme == null) {
            Lesson.createEmpty()
        } else {
            lessonFactory.create(lessonJsonScheme)
        }
    }
}