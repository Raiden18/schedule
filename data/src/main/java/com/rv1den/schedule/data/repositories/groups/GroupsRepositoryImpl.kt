package com.rv1den.schedule.data.repositories.groups

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.repositories.GroupsRepository

class GroupsRepositoryImpl(
    private val groupsFacadeRestClient: GroupsFacadeRestClient
) : GroupsRepository {
    override fun getGroups(): List<Group> {
        return groupsFacadeRestClient.getGroups()
    }
}