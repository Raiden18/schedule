package com.rv1den.schedule.api.mappers

import com.rv1den.schedule.api.jsons.DayScheduleJsonScheme
import com.rv1den.schedule.api.jsons.LessonJsonScheme
import com.rv1den.schedule.domain.models.values.Number
import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.models.values.lesson.Lesson

class SchoolDayMapper(
    private val lessonResponseMapper: Mapper<LessonJsonScheme?, Lesson>
) : Mapper<DayScheduleJsonScheme, SchoolDay> {

    override fun map(response: DayScheduleJsonScheme): SchoolDay {
        val firstLesson = lessonResponseMapper.map(response.first)
        val secondLesson = lessonResponseMapper.map(response.second)
        val thirdLesson = lessonResponseMapper.map(response.third)
        val fourthLesson = lessonResponseMapper.map(response.fourth)
        val fifthLesson = lessonResponseMapper.map(response.fifth)
        val dayNumber = Number(response.dayNumber)
        return SchoolDay(
            firstLesson,
            secondLesson,
            thirdLesson,
            fourthLesson,
            fifthLesson,
            dayNumber
        )
    }
}