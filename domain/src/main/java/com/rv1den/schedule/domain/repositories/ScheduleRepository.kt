package com.rv1den.schedule.domain.repositories

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

interface ScheduleRepository {
    fun getScheduleFor(group: Group): Schedule
    fun saveSchoolDay(schoolDay: SchoolDay)
    fun saveWeek(schoolWeek: SchoolWeek)
}