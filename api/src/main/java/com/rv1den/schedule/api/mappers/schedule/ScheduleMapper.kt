package com.rv1den.schedule.api.mappers.schedule

import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.schedule.Schedule

interface ScheduleMapper {
    fun map(scheduleResponse: ScheduleJsonScheme?): Schedule
}