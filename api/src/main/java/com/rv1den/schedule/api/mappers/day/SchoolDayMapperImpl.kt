package com.rv1den.schedule.api.mappers.day

import com.rv1den.schedule.api.jsons.DayScheduleJsonScheme
import com.rv1den.schedule.api.mappers.lesson.LessonResponseMapper
import com.rv1den.schedule.domain.models.values.Number
import com.rv1den.schedule.domain.models.values.day.SchoolDay

class SchoolDayMapperImpl(
    private val lessonResponseMapper: LessonResponseMapper
) : SchoolDayMapper {

    override fun convert(schoolDayScheduleJsonScheme: DayScheduleJsonScheme): SchoolDay {
        val firstLesson = lessonResponseMapper.map(schoolDayScheduleJsonScheme.first)
        val secondLesson = lessonResponseMapper.map(schoolDayScheduleJsonScheme.second)
        val thirdLesson = lessonResponseMapper.map(schoolDayScheduleJsonScheme.third)
        val fourthLesson = lessonResponseMapper.map(schoolDayScheduleJsonScheme.fourth)
        val fifthLesson = lessonResponseMapper.map(schoolDayScheduleJsonScheme.fifth)
        val dayNumber = Number(schoolDayScheduleJsonScheme.dayNumber)
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