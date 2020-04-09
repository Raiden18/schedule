package com.rv1den.schedule.rest_client.facades

import android.util.Log
import com.rv1den.schedule.data.repositories.groups.GroupsRepositoryRestClient
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.rest_client.GROUPS_URL
import com.rv1den.schedule.rest_client.client.RestClient


class GroupsRepositoryRestClientImpl(
    private val restClient: RestClient
) : GroupsRepositoryRestClient {
    override fun getGroups(): List<Group> {
        val response = restClient.getJson(GROUPS_URL)
        Log.i("HUI", GROUPS_URL)
        Log.i("HUI", response)
        return emptyList()
    }
}