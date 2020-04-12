package com.rv1den.schedule.api.mappers.weeks.even

import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.api.mappers.weeks.factory.WeekFactory
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

class EvenWeekMapperImpl(
    private val weekFactory: WeekFactory
) : EvenWeekMapper {

    override fun map(scheduleResponse: ScheduleJsonScheme): SchoolWeek {
        val mondayOfEvenWeekResponse = scheduleResponse.eighth
        val tuesdayOfEvenWeekResponse = scheduleResponse.ninth
        val wednesdayOfEvenWeekResponse = scheduleResponse.tenth
        val thursdayOfEvenWeekResponse = scheduleResponse.eleventh
        val fridayOfEvenWeekResponse = scheduleResponse.twelfth
        val saturdayOfEvenWeekResponse = scheduleResponse.thirteenth
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