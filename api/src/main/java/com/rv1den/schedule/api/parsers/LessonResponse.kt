package com.rv1den.schedule.api.parsers

import com.rv1den.schedule.api.jsons.LessonJsonScheme
import org.json.JSONObject

class LessonResponse(
    private val jsonObject: JSONObject
) : LessonJsonScheme {
    private companion object {
        const val LESSON_NAME_KEY = "lesson_name"
        const val TEACHER_NAME_KEY = "teacher_name"
        const val AUDITORY_KEY = "auditory"
        const val TIME_FROM_KEY = "time_from"
        const val TIME_TO_KEY = "time_to"
        const val TYPE_KEY = "type"
        const val LESSON_NUMBER_KEY = "lesson_number"
    }

    override val lessonName: String
        get() = jsonObject.getString(LESSON_NAME_KEY)
    override val teacherName: String
        get() = jsonObject.getString(TEACHER_NAME_KEY)
    override val auditory: String
        get() = jsonObject.getString(AUDITORY_KEY)
    override val timeFrom: String
        get() = jsonObject.getString(TIME_FROM_KEY)
    override val timeTo: String
        get() = jsonObject.getString(TIME_TO_KEY)
    override val type: String
        get() = jsonObject.getString(TYPE_KEY)
    override val lessonNumber: Int
        get() = jsonObject.getInt(LESSON_NUMBER_KEY)
}