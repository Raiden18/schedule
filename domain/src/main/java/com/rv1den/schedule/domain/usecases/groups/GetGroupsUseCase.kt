package com.rv1den.schedule.domain.usecases.groups

import com.rv1den.schedule.domain.models.enteties.Group

interface GetGroupsUseCase {
    fun execute(): List<Group>
}