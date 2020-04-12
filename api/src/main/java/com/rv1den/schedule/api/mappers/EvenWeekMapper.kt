package com.rv1den.schedule.api.mappers

import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.api.mappers.factories.week.WeekFactory
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

class EvenWeekMapper(
    private val weekFactory: WeekFactory
) : Mapper<ScheduleJsonScheme, SchoolWeek> {

    override fun map(response: ScheduleJsonScheme): SchoolWeek {
        val mondayOfEvenWeekResponse = response.eighth
        val tuesdayOfEvenWeekResponse = response.ninth
        val wednesdayOfEvenWeekResponse = response.tenth
        val thursdayOfEvenWeekResponse = response.eleventh
        val fridayOfEvenWeekResponse = response.twelfth
        val saturdayOfEvenWeekResponse = response.thirteenth
        return weekFactory.create(
            mondayOfEvenWeekResponse,
            tuesdayOfEvenWeekResponse,
            wednesdayOfEvenWeekResponse,
            thursdayOfEvenWeekResponse,
            fridayOfEvenWeekResponse,
            saturdayOfEvenWeekResponse
        )
    }
}