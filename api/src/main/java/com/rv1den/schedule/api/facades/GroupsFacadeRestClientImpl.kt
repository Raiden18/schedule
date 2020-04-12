package com.rv1den.schedule.api.facades

import com.rv1den.schedule.api.GROUPS_URL
import com.rv1den.schedule.api.client.RestClient
import com.rv1den.schedule.api.jsons.GroupJsonScheme
import com.rv1den.schedule.api.mappers.Mapper
import com.rv1den.schedule.api.parsers.BodyResponse
import com.rv1den.schedule.api.parsers.UniversityResponse
import com.rv1den.schedule.data.repositories.groups.GroupsFacadeRestClient
import com.rv1den.schedule.domain.models.enteties.Group

class GroupsFacadeRestClientImpl(
    private val restClient: RestClient,
    private val groupsMapper: Mapper<List<GroupJsonScheme>, List<Group>>
) : GroupsFacadeRestClient {

    override fun getGroups(): List<Group> {
        val response = restClient.getJson(GROUPS_URL)
        val bodyParser = BodyResponse(response)
        val body = bodyParser.body
        val jsonGroups = UniversityResponse(body)
        val groups = jsonGroups.groups
        return groupsMapper.map(groups)
    }
}