package com.rv1den.schedule.data.repositories.schedule

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek
import com.rv1den.schedule.domain.repositories.ScheduleRepository

class ScheduleRepositoryImpl(
    private val scheduleFacadeRestClient: ScheduleFacadeRestClient
) : ScheduleRepository {
    private lateinit var cacheSchedule: Schedule
    private lateinit var cacheSchoolDay: SchoolDay

    override fun getScheduleFor(group: Group): Schedule {
        this.cacheSchedule = scheduleFacadeRestClient.getSchedule(group)
        return cacheSchedule
    }

    override fun saveSchoolDay(schoolDay: SchoolDay) {
        cacheSchoolDay = schoolDay
    }

    override fun saveWeek(schoolWeek: SchoolWeek) {

    }
}