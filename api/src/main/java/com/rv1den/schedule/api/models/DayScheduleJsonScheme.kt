package com.rv1den.schedule.api.models

interface DayScheduleJsonScheme {
    val first: LessonJsonScheme?
    val second: LessonJsonScheme?
    val third: LessonJsonScheme?
    val fourth: LessonJsonScheme?
    val fifth: LessonJsonScheme?
    val dayNumber: Int
}