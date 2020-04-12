package com.rv1den.schedule.domain.usecases.group

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.repositories.GroupRepository

class SaveGroupUseCase(private val groupRepository: GroupRepository) {

    fun execute(group: Group) {
        groupRepository.save(group)
    }
}