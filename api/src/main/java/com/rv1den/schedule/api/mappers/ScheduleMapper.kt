package com.rv1den.schedule.api.mappers

import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.domain.models.values.schedule.Schedule

class ScheduleMapper(
    private val evenWeekMapper: EvenWeekMapper,
    private val oddWeekMapper: OddWeekMapper
) : Mapper<ScheduleJsonScheme?, Schedule> {

    override fun map(response: ScheduleJsonScheme?): Schedule {
        return if (response == null) {
            Schedule.createEmpty()
        } else {
            Schedule(
                oddWeekMapper.map(response),
                evenWeekMapper.map(response)
            )
        }
    }
}