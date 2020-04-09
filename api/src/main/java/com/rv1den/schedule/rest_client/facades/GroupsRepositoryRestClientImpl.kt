package com.rv1den.schedule.rest_client.facades

import com.rv1den.schedule.data.repositories.groups.GroupsRepositoryRestClient
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.rest_client.GROUPS_URL
import com.rv1den.schedule.rest_client.client.RestClient
import com.rv1den.schedule.rest_client.parsers.groups.GroupsParser
import org.json.JSONArray


class GroupsRepositoryRestClientImpl(
    private val restClient: RestClient,
    private val groupsParser: GroupsParser
) : GroupsRepositoryRestClient {
    private companion object KEYS {
        const val GROUPS = "groups"
    }

    override fun getGroups(): List<Group> {
        val response = restClient.getJson(GROUPS_URL)
        val jsonArray = JSONArray(response)
        val body = jsonArray.getJSONObject(0)
        val jsonGroups = body.getJSONArray(GROUPS)
        return groupsParser.parse(jsonGroups)
    }
}