package com.rv1den.schedule.api.parsers

import com.rv1den.schedule.api.jsons.DayScheduleJsonScheme
import com.rv1den.schedule.api.jsons.LessonJsonScheme
import org.json.JSONObject

class SchoolDayResponse(
    private val jsonObject: JSONObject
) : DayScheduleJsonScheme {
    private companion object {
        const val FIRST = "1"
        const val SECOND = "2"
        const val THIRD = "3"
        const val FOURTH = "4"
        const val FIFTH = "5"
        const val DAY_NUMBER = "day_number"
    }

    override val first: LessonJsonScheme?
        get() = createLesson(FIRST)
    override val second: LessonJsonScheme?
        get() = createLesson(SECOND)
    override val third: LessonJsonScheme?
        get() = createLesson(THIRD)
    override val fourth: LessonJsonScheme?
        get() = createLesson(FOURTH)
    override val fifth: LessonJsonScheme?
        get() = createLesson(FIFTH)
    override val dayNumber: Int
        get() = jsonObject.optInt(DAY_NUMBER)

    private fun createLesson(key: String): LessonJsonScheme? {
        val lessonJson = jsonObject.optJSONObject(key)
        return if (lessonJson == null){
            null
        } else {
            LessonResponse(lessonJson)
        }
    }
}