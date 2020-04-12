package com.rv1den.schedule.api.mappers.group

import com.rv1den.schedule.api.jsons.GroupJsonScheme
import com.rv1den.schedule.domain.models.enteties.Group

interface GroupsMapper {
    fun map(groupsResponse: List<GroupJsonScheme>): List<Group>
}