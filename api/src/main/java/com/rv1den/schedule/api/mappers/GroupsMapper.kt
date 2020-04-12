package com.rv1den.schedule.api.mappers

import com.rv1den.schedule.api.jsons.GroupJsonScheme
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.group.GroupTitle

class GroupsMapper : Mapper<List<GroupJsonScheme>, List<Group>> {

    override fun map(response: List<GroupJsonScheme>): List<Group> {
        return response.map {
            val groupName = it.name
            val groupId = it.id
            val title = GroupTitle(groupName)
            Group(groupId, title)
        }
    }
}