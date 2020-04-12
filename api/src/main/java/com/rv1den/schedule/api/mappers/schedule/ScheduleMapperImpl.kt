package com.rv1den.schedule.api.mappers.schedule

import com.rv1den.schedule.api.mappers.weeks.even.EvenWeekMapper
import com.rv1den.schedule.api.mappers.weeks.odd.OddWeekMapper
import com.rv1den.schedule.api.models.ScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.schedule.Schedule

class ScheduleMapperImpl(
    private val evenWeekMapper: EvenWeekMapper,
    private val oddWeekMapper: OddWeekMapper
) : ScheduleMapper {

    override fun map(scheduleResponse: ScheduleJsonScheme?): Schedule {
        return if (scheduleResponse == null) {
            Schedule.createEmpty()
        } else {
            Schedule(
                oddWeekMapper.map(scheduleResponse),
                evenWeekMapper.map(scheduleResponse)
            )
        }
    }
}