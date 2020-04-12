package com.rv1den.schedule.api.facades

import com.rv1den.schedule.api.GROUPS_URL
import com.rv1den.schedule.api.client.RestClient
import com.rv1den.schedule.api.mappers.group.GroupsMapper
import com.rv1den.schedule.api.parsers.UniversityResponse
import com.rv1den.schedule.data.repositories.groups.GroupsFacadeRestClient
import com.rv1den.schedule.domain.models.enteties.Group
import org.json.JSONArray


class GroupsFacadeRestClientImpl(
    private val restClient: RestClient,
    private val groupsMapper: GroupsMapper
) : GroupsFacadeRestClient {

    override fun getGroups(): List<Group> {
        val response = restClient.getJson(GROUPS_URL)
        val jsonArray = JSONArray(response)
        val body = jsonArray.getJSONObject(0)
        val jsonGroups = UniversityResponse(body)
        val groups = jsonGroups.groups
        return groupsMapper.map(groups)
    }
}