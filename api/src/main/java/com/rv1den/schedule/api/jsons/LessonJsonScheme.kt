package com.rv1den.schedule.api.jsons

interface LessonJsonScheme {
    val lessonName: String
    val teacherName: String
    val auditory: String
    val timeFrom: String
    val timeTo: String
    val type: String
    val lessonNumber: Int
}