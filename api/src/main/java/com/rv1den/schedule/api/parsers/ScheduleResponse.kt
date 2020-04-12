package com.rv1den.schedule.api.parsers

import com.rv1den.schedule.api.jsons.DayScheduleJsonScheme
import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import org.json.JSONObject

class ScheduleResponse(
    private val jsonObject: JSONObject
) : ScheduleJsonScheme {
    private companion object {
        const val FIRST = "1"
        const val SECOND = "2"
        const val THIRD = "3"
        const val FOURTH = "4"
        const val FIFTH = "5"
        const val SIXTH = "6"
        const val EIGHTH = "6"
        const val NINTH = "9"
        const val TENTH = "10"
        const val ELEVENTH = "11"
        const val TWELFTH = "12"
        const val THIRTEENTH = "13"
    }

    override val first: DayScheduleJsonScheme?
        get() = getDay(FIRST)
    override val second: DayScheduleJsonScheme?
        get() = getDay(SECOND)
    override val third: DayScheduleJsonScheme?
        get() = getDay(THIRD)
    override val fourth: DayScheduleJsonScheme?
        get() = getDay(FOURTH)
    override val fifth: DayScheduleJsonScheme?
        get() = getDay(FIFTH)
    override val sixth: DayScheduleJsonScheme?
        get() = getDay(SIXTH)
    override val eighth: DayScheduleJsonScheme?
        get() = getDay(EIGHTH)
    override val ninth: DayScheduleJsonScheme?
        get() = getDay(NINTH)
    override val tenth: DayScheduleJsonScheme?
        get() = getDay(TENTH)
    override val eleventh: DayScheduleJsonScheme?
        get() = getDay(ELEVENTH)
    override val twelfth: DayScheduleJsonScheme?
        get() = getDay(TWELFTH)
    override val thirteenth: DayScheduleJsonScheme?
        get() = getDay(THIRTEENTH)

    private fun getDay(dayNumber: String): DayScheduleJsonScheme? {
        val jsonDay = jsonObject.optJSONObject(dayNumber)
        return if (jsonDay == null) {
            null
        } else {
            SchoolDayResponse(jsonDay)
        }
    }
}