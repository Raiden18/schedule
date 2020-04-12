package com.rv1den.schedule.api.mappers.group

import com.rv1den.schedule.api.jsons.GroupJsonScheme
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.group.GroupTitle

class GroupsMapperImpl : GroupsMapper {

    override fun map(groupsResponse: List<GroupJsonScheme>): List<Group> {
        return groupsResponse.map {
            val groupName = it.name
            val groupId = it.id
            val title = GroupTitle(groupName)
            Group(groupId, title)
        }
    }
}