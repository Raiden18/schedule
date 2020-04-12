package com.rv1den.schedule.api.mappers.factories.week

import com.rv1den.schedule.api.jsons.DayScheduleJsonScheme
import com.rv1den.schedule.api.mappers.Mapper
import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

class WeekFactoryImpl(
    private val schoolDayMapper: Mapper<DayScheduleJsonScheme, SchoolDay>
) : WeekFactory {
    override fun create(
        mondayResponse: DayScheduleJsonScheme?,
        tuesdayResponse: DayScheduleJsonScheme?,
        wednesdayResponse: DayScheduleJsonScheme?,
        thursdayResponse: DayScheduleJsonScheme?,
        fridayResponse: DayScheduleJsonScheme?,
        saturdayResponse: DayScheduleJsonScheme?
    ): SchoolWeek {
        val mondayOfOddWeek = if (mondayResponse == null) {
            SchoolWeek.createEmptyMonday()
        } else {
            schoolDayMapper.map(mondayResponse)
        }
        val tuesdayOfOddWeek = if (tuesdayResponse == null) {
            SchoolWeek.createEmptyTuesday()
        } else {
            schoolDayMapper.map(tuesdayResponse)
        }
        val wednesdayOfOddWeek = if (wednesdayResponse == null) {
            SchoolWeek.createEmptyWednesday()
        } else {
            schoolDayMapper.map(wednesdayResponse)
        }
        val thursdayOfOddWeek = if (thursdayResponse == null) {
            SchoolWeek.createEmptyThursday()
        } else {
            schoolDayMapper.map(thursdayResponse)
        }
        val fridayOfOddWeek = if (fridayResponse == null) {
            SchoolWeek.createEmptyFriday()
        } else {
            schoolDayMapper.map(fridayResponse)
        }
        val saturdayOfOddWeek = if (saturdayResponse == null) {
            SchoolWeek.createEmptySaturday()
        } else {
            schoolDayMapper.map(saturdayResponse)
        }
        return SchoolWeek(
            mondayOfOddWeek,
            tuesdayOfOddWeek,
            wednesdayOfOddWeek,
            thursdayOfOddWeek,
            fridayOfOddWeek,
            saturdayOfOddWeek
        )
    }
}