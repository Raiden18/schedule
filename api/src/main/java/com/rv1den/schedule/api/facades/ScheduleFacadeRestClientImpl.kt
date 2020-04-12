package com.rv1den.schedule.api.facades

import com.rv1den.schedule.api.GROUP_SCHEDULE
import com.rv1den.schedule.api.client.RestClient
import com.rv1den.schedule.api.jsons.ScheduleJsonScheme
import com.rv1den.schedule.api.mappers.Mapper
import com.rv1den.schedule.api.parsers.BodyResponse
import com.rv1den.schedule.api.parsers.ScheduleResponse
import com.rv1den.schedule.data.repositories.schedule.ScheduleFacadeRestClient
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.schedule.Schedule

class ScheduleFacadeRestClientImpl(
    private val restClient: RestClient,
    private val scheduleMapper: Mapper<ScheduleJsonScheme?, Schedule>
) : ScheduleFacadeRestClient {

    override fun getSchedule(group: Group): Schedule {
        val groupId = group.id.toString()
        val resultUrl = GROUP_SCHEDULE + groupId
        val resultJson = restClient.getJson(resultUrl)
        val bodyResponse = BodyResponse(resultJson)
        return tryToParse(bodyResponse)
    }
    /**
     * RestApi returns 2 arrays that is put one into another if result is empty
     */
    private fun tryToParse(bodyResponse: BodyResponse): Schedule {
        return try {
            parseResponse(bodyResponse)
        } catch (e: IllegalStateException) {
            Schedule.createEmpty()
        }
    }

    private fun parseResponse(bodyResponse: BodyResponse): Schedule{
        val scheduleResponse = ScheduleResponse(bodyResponse.body)
        return scheduleMapper.map(scheduleResponse)
    }
}