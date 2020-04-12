package com.rv1den.schedule.api.mappers.day

import com.rv1den.schedule.api.models.DayScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.day.SchoolDay

interface SchoolDayMapper {
    fun convert(schoolDayScheduleJsonScheme: DayScheduleJsonScheme): SchoolDay
}