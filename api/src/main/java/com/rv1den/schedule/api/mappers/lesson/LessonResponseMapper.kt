package com.rv1den.schedule.api.mappers.lesson

import com.rv1den.schedule.api.jsons.LessonJsonScheme
import com.rv1den.schedule.domain.models.values.lesson.Lesson

interface LessonResponseMapper {
    fun map(lessonJsonScheme: LessonJsonScheme?): Lesson
}