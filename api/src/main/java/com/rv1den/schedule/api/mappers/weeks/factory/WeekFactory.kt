package com.rv1den.schedule.api.mappers.weeks.factory

import com.rv1den.schedule.api.models.DayScheduleJsonScheme
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