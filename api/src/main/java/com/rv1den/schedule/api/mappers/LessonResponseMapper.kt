package com.rv1den.schedule.api.mappers

import com.rv1den.schedule.api.jsons.LessonJsonScheme
import com.rv1den.schedule.api.mappers.factories.lesson.LessonFactory
import com.rv1den.schedule.domain.models.values.lesson.Lesson

class LessonResponseMapper(
    private val lessonFactory: LessonFactory
) : Mapper<LessonJsonScheme?, Lesson> {

    override fun map(response: LessonJsonScheme?): Lesson {
        return if (response == null) {
            Lesson.createEmpty()
        } else {
            lessonFactory.create(response)
        }
    }
}