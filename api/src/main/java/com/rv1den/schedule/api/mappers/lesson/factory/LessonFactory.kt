package com.rv1den.schedule.api.mappers.lesson.factory

import com.rv1den.schedule.api.models.LessonJsonScheme
import com.rv1den.schedule.domain.models.values.lesson.Lesson

interface LessonFactory {
    fun create(lessonJsonScheme: LessonJsonScheme): Lesson
}