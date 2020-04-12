package com.rv1den.schedule.api.mappers.weeks.odd

import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

interface OddWeekMapper {
    fun map(scheduleResponse: ScheduleJsonScheme): SchoolWeek
}