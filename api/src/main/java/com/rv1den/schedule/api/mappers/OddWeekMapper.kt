package com.rv1den.schedule.api.mappers

import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.api.mappers.factories.week.WeekFactory
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

class OddWeekMapper(
    private val weekFactory: WeekFactory
) : Mapper<ScheduleJsonScheme, SchoolWeek> {

    override fun map(response: ScheduleJsonScheme): SchoolWeek {
        val mondayOfOddWeekResponse = response.first
        val tuesdayOfOddWeekResponse = response.second
        val wednesdayOfOddWeekResponse = response.third
        val thursdayOfOddWeekResponse = response.fourth
        val fridayOfOddWeekResponse = response.fifth
        val saturdayOfOddWeekResponse = response.sixth
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