package com.rv1den.schedule.api.mappers.factories.lesson

import com.rv1den.schedule.api.jsons.LessonJsonScheme
import com.rv1den.schedule.domain.models.values.lesson.Lesson

interface LessonFactory {
    fun create(lessonJsonScheme: LessonJsonScheme): Lesson
}