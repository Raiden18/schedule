package com.rv1den.schedule.api.mappers

import com.rv1den.schedule.api.mappers.schedule.ScheduleMapper
import com.rv1den.schedule.api.mappers.schedule.ScheduleMapperImpl
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ScheduleMapperImplTest {
    private lateinit var scheduleMapper: ScheduleMapper

    @Before
    fun setUp() {
        scheduleMapper =
            ScheduleMapperImpl()
    }

    @Test
    fun `Should return empty schedule if response is null`(){
        //Given
        val response = null

        //Then
        val result = scheduleMapper.map(response)

        //When
        assertTrue(result.isEmpty())
    }

    @Test
    fun `Sho`
}