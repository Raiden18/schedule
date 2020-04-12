package com.rv1den.schedule.api.mappers.weeks.factory

import com.rv1den.schedule.api.jsons.DayScheduleJsonScheme
import com.rv1den.schedule.api.mappers.day.SchoolDayMapper
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

class WeekFactoryImpl(
    private val schoolDayMapper: SchoolDayMapper
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
            schoolDayMapper.convert(mondayResponse)
        }
        val tuesdayOfOddWeek = if (tuesdayResponse == null) {
            SchoolWeek.createEmptyTuesday()
        } else {
            schoolDayMapper.convert(tuesdayResponse)
        }
        val wednesdayOfOddWeek = if (wednesdayResponse == null) {
            SchoolWeek.createEmptyWednesday()
        } else {
            schoolDayMapper.convert(wednesdayResponse)
        }
        val thursdayOfOddWeek = if (thursdayResponse == null) {
            SchoolWeek.createEmptyThursday()
        } else {
            schoolDayMapper.convert(thursdayResponse)
        }
        val fridayOfOddWeek = if (fridayResponse == null) {
            SchoolWeek.createEmptyFriday()
        } else {
            schoolDayMapper.convert(fridayResponse)
        }
        val saturdayOfOddWeek = if (saturdayResponse == null) {
            SchoolWeek.createEmptySaturday()
        } else {
            schoolDayMapper.convert(saturdayResponse)
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