package com.rv1den.schedule.api.mappers.factories.week

import com.rv1den.schedule.api.jsons.DayScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

interface WeekFactory {
    fun create(
        mondayResponse: DayScheduleJsonScheme?,
        tuesdayResponse: DayScheduleJsonScheme?,
        wednesdayResponse: DayScheduleJsonScheme?,
        thursdayResponse: DayScheduleJsonScheme?,
        fridayResponse: DayScheduleJsonScheme?,
        saturdayResponse: DayScheduleJsonScheme?
    ): SchoolWeek
}