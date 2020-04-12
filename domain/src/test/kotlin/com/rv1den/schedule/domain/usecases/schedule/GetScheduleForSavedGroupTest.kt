package com.rv1den.schedule.domain.usecases.schedule

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import com.rv1den.schedule.domain.repositories.GroupRepository
import com.rv1den.schedule.domain.repositories.ScheduleRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetScheduleForSavedGroupTest {
    private lateinit var scheduleRepository: ScheduleRepository
    private lateinit var groupRepository: GroupRepository
    private lateinit var getScheduleForSavedGroup: GetScheduleForSavedGroup

    @Before
    fun setUp() {
        scheduleRepository = spyk()
        groupRepository = spyk()
        getScheduleForSavedGroup = GetScheduleForSavedGroup(scheduleRepository, groupRepository)
    }

    @Test
    fun `Should get saved group and then fetch schedule for this group`(){
        //Given
        val group: Group = mockk()
        val schedule: Schedule = mockk()
        every {
            groupRepository.getSavedGroup()
        } returns group
        every {
            scheduleRepository.getScheduleFor(group)
        } returns schedule

        //When
        val resultSchedule = getScheduleForSavedGroup.execute()

        //Then
        assertEquals(schedule, resultSchedule)
    }
}