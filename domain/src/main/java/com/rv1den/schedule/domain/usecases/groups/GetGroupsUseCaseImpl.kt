package com.rv1den.schedule.domain.usecases.groups

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.repositories.GroupsRepository

class GetGroupsUseCaseImpl(
    private val groupsRepository: GroupsRepository
) {

    fun execute(): List<Group> {
        return groupsRepository.getGroups()
    }
}