package com.rv1den.schedule.data.repositories.schedule

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import com.rv1den.schedule.domain.repositories.ScheduleRepository

class ScheduleRepositoryImpl(
    private val scheduleFacadeRestClient: ScheduleFacadeRestClient
): ScheduleRepository {

    override fun getScheduleFor(group: Group): Schedule {
        return scheduleFacadeRestClient.getSchedule(group)
    }
}