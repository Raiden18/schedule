package com.rv1den.schedule.api.facades

import com.rv1den.schedule.api.GROUPS_URL
import com.rv1den.schedule.api.client.RestClient
import com.rv1den.schedule.api.parsers.groups.GroupsParser
import com.rv1den.schedule.data.repositories.groups.GroupsFacadeRestClient
import com.rv1den.schedule.domain.models.enteties.Group
import org.json.JSONArray


class GroupsFacadeRestClientImpl(
    private val restClient: RestClient,
    private val groupsParser: GroupsParser
) : GroupsFacadeRestClient {
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