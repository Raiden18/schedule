package com.rv1den.schedule.data.repositories.groups

import com.rv1den.schedule.domain.models.enteties.Group

interface GroupsFacadeRestClient {
    fun getGroups(): List<Group>
}