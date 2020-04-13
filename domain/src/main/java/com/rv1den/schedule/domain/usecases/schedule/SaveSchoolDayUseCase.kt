package com.rv1den.schedule.domain.usecases.schedule

import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.repositories.ScheduleRepository

class SaveSchoolDayUseCase(
    private val scheduleRepository: ScheduleRepository
) {

    fun execute(schoolDay: SchoolDay){
        scheduleRepository.saveSchoolDay(schoolDay)
    }
}