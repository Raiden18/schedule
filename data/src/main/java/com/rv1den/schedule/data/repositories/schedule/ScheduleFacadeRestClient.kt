package com.rv1den.schedule.data.repositories.schedule

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.schedule.Schedule

interface ScheduleFacadeRestClient {
    fun getSchedule(group: Group): Schedule
}