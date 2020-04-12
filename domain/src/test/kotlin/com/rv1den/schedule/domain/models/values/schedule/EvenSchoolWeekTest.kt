package com.rv1den.schedule.domain.models.values.schedule

import com.rv1den.schedule.domain.models.values.day.SchoolDay
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EvenSchoolWeekTest {
    private lateinit var evenSchoolWeek: EvenSchoolWeek
    private lateinit var monday: SchoolDay
    private lateinit var tuesday: SchoolDay
    private lateinit var wednesday: SchoolDay
    private lateinit var thursday: SchoolDay
    private lateinit var friday: SchoolDay
    private lateinit var saturday: SchoolDay

    @Before
    fun setUp() {
        monday = mockk(relaxed = true)
        every {
            monday.number
        } returns 1
        tuesday = mockk(relaxed = true)
        every{
            tuesday.number
        } returns 2
        wednesday = mockk(relaxed = true)
        every {
            wednesday.number
        } returns 3
        thursday = mockk(relaxed = true)
        every {
            thursday.number
        } returns 4
        friday = mockk(relaxed = true)
        every {
            friday.number
        } returns 5
        saturday = mockk(relaxed = true)
        every {
            saturday.number
        } returns 6

    }

    @Test
    fun `Should return monday if monday exist`() {
        //Given
        createWeekWith(monday)

        //When
        val mondayResult = evenSchoolWeek.monday

        //Then
        assertEquals(monday, mondayResult)
    }

    @Test
    fun `Should return true object if there is no monday`() {
        //Given
        evenSchoolWeek = EvenSchoolWeek.createEmpty()

        //When
        val mondayResult = evenSchoolWeek.monday

        //Then
        assertTrue(mondayResult.isNoLessons)
    }

    @Test
    fun `Should return tuesday if that day exists`() {
        //Given
        createWeekWith(tuesday)

        //When
        val dayResult = evenSchoolWeek.tuesday

        //Then
        assertEquals(tuesday, dayResult)
    }

    @Test
    fun `Should return true if there is no lessons on tuesday`() {
        //Given
        evenSchoolWeek = EvenSchoolWeek.createEmpty()

        //When
        val dayResult = evenSchoolWeek.tuesday

        //Then
        assertTrue(dayResult.isNoLessons)
    }

    @Test
    fun `Should return wednesday if that day exists`() {
        //Given
        createWeekWith(wednesday)

        //When
        val dayResult = evenSchoolWeek.wednesday

        //Then
        assertEquals(wednesday, dayResult)
    }

    @Test
    fun `Should return true if there is no lessons on wednesday`() {
        //Given
        evenSchoolWeek = EvenSchoolWeek.createEmpty()

        //When
        val dayResult = evenSchoolWeek.wednesday

        //Then
        assertTrue(dayResult.isNoLessons)
    }

    @Test
    fun `Should return thursday if that day exists`() {
        //Given
        createWeekWith(thursday)

        //When
        val dayResult = evenSchoolWeek.thursday

        //Then
        assertEquals(thursday, dayResult)
    }

    @Test
    fun `Should return true if there is no lessons on thursday`() {
        //Given
        evenSchoolWeek = EvenSchoolWeek.createEmpty()

        //When
        val dayResult = evenSchoolWeek.thursday

        //Then
        assertTrue(dayResult.isNoLessons)
    }

    @Test
    fun `Should return friday if that day exists`() {
        //Given
        createWeekWith(friday)

        //When
        val dayResult = evenSchoolWeek.friday

        //Then
        assertEquals(friday, dayResult)
    }

    @Test
    fun `Should return true if there is no lessons on friday`() {
        //Given
        evenSchoolWeek = EvenSchoolWeek.createEmpty()

        //When
        val dayResult = evenSchoolWeek.friday

        //Then
        assertTrue(dayResult.isNoLessons)
    }

    @Test
    fun `Should return saturday if that day exists`() {
        //Given
        createWeekWith(saturday)

        //When
        val dayResult = evenSchoolWeek.saturday

        //Then
        assertEquals(saturday, dayResult)
    }

    @Test
    fun `Should return true if there is no lessons on saturday`() {
        //Given
        evenSchoolWeek = EvenSchoolWeek.createEmpty()

        //When
        val dayResult = evenSchoolWeek.saturday

        //Then
        assertTrue(dayResult.isNoLessons)
    }


    private fun createWeekWith(schoolDay: SchoolDay) {
        val schoolDays = listOf(
            schoolDay
        )
        evenSchoolWeek = EvenSchoolWeek(schoolDays)
    }
}