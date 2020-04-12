package com.rv1den.schedule.domain.usecases.schedule

import com.rv1den.schedule.domain.models.values.schedule.Schedule
import com.rv1den.schedule.domain.repositories.GroupRepository
import com.rv1den.schedule.domain.repositories.ScheduleRepository

class GetScheduleForSavedGroup(
    private val scheduleRepository: ScheduleRepository,
    private val groupRepository: GroupRepository
) {

    fun execute(): Schedule {
        val savedGroup = groupRepository.getSavedGroup()
        return scheduleRepository.getScheduleFor(savedGroup)
    }
}