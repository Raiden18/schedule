package com.rv1den.schedule.api.mappers.weeks.even

import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

interface EvenWeekMapper {
    fun map(scheduleResponse: ScheduleJsonScheme): SchoolWeek
}