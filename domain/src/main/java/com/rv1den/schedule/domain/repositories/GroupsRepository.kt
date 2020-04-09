package com.rv1den.schedule.domain.repositories

import com.rv1den.schedule.domain.models.enteties.Group

interface GroupsRepository {
    fun getGroups(): List<Group>
}