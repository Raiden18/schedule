package com.rv1den.schedule.domain.repositories

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.schedule.Schedule

interface ScheduleRepository {
    fun getScheduleFor(group: Group): Schedule
}