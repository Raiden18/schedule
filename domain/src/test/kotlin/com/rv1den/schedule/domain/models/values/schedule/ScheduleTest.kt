package com.rv1den.schedule.domain.models.values.schedule

import io.mockk.mockk
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ScheduleTest {

    @Test
    fun `Should return true if schedule was created as empty`(){
        //Given
        val emptySchedule = Schedule.createEmpty()

        //When
        val isEmpty = emptySchedule.isEmpty()

        //Then
        assertTrue(isEmpty)
    }

    @Test
    fun `Should return false if odd schedule is not empty`(){
        //Given
        val oddSchoolWeek = SchoolWeek(listOf(mockk()))
        val evenSchoolWeek = EvenSchoolWeek.createEmpty()
        val schedule = Schedule(oddSchoolWeek, evenSchoolWeek)

        //When
        val isEmpty = schedule.isEmpty()

        //Then
        assertFalse(isEmpty)
    }

    @Test
    fun `Should return false if even schedule is not empty`(){
        //Given
        val oddSchoolWeek = SchoolWeek.createEmpty()
        val evenSchoolWeek = EvenSchoolWeek((listOf(mockk())))
        val schedule = Schedule(oddSchoolWeek, evenSchoolWeek)

        //When
        val isEmpty = schedule.isEmpty()

        //Then
        assertFalse(isEmpty)
    }
}