package com.rv1den.schedule.api.facades

import com.rv1den.schedule.api.GROUP_SCHEDULE
import com.rv1den.schedule.api.client.RestClient
import com.rv1den.schedule.api.mappers.schedule.ScheduleMapper
import com.rv1den.schedule.api.parsers.schedule.ScheduleResponse
import com.rv1den.schedule.data.repositories.schedule.ScheduleFacadeRestClient
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import org.json.JSONArray

class ScheduleFacadeRestClientImpl(
    private val restClient: RestClient,
    private val scheduleMapper: ScheduleMapper
) : ScheduleFacadeRestClient {

    override fun getSchedule(group: Group): Schedule {
        val groupId = group.id.toString()
        val resultUrl = GROUP_SCHEDULE + groupId
        val resultJson = restClient.getJson(resultUrl)
        val jsonArray = JSONArray(resultJson)
        val body = jsonArray.getJSONObject(0)
        val scheduleResponse = ScheduleResponse(body)
        return scheduleMapper.map(scheduleResponse)
    }
}