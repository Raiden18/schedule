package com.rv1den.schedule.api.mappers.weeks.odd

import com.rv1den.schedule.api.mappers.weeks.factory.WeekFactory
import com.rv1den.schedule.api.models.ScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

class OddWeekMapperImpl(
    private val weekFactory: WeekFactory
) : OddWeekMapper {

    override fun map(scheduleResponse: ScheduleJsonScheme): SchoolWeek {
        val mondayOfOddWeekResponse = scheduleResponse.first
        val tuesdayOfOddWeekResponse = scheduleResponse.second
        val wednesdayOfOddWeekResponse = scheduleResponse.third
        val thursdayOfOddWeekResponse = scheduleResponse.fourth
        val fridayOfOddWeekResponse = scheduleResponse.fifth
        val saturdayOfOddWeekResponse = scheduleResponse.sixth
        return weekFactory.create(
            mondayOfOddWeekResponse,
            tuesdayOfOddWeekResponse,
            wednesdayOfOddWeekResponse,
            thursdayOfOddWeekResponse,
            fridayOfOddWeekResponse,
            saturdayOfOddWeekResponse
        )
    }
}