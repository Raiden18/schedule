package com.rv1den.schedule.data.repositories.groups

import com.rv1den.schedule.domain.models.enteties.Group

interface GroupsRepositoryRestClient {
    fun getGroups(): List<Group>
}