package com.rv1den.schedule.data.repositories.group

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.repositories.GroupRepository

class GroupRepositoryImpl: GroupRepository {
    private var groupCache: Group? = null

    override fun save(group: Group) {
        this.groupCache = group
    }

    override fun getSavedGroup(): Group {
        return groupCache!!
    }
}