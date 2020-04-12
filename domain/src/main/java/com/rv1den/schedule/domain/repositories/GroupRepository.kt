package com.rv1den.schedule.domain.repositories

import com.rv1den.schedule.domain.models.enteties.Group


interface GroupRepository {
    fun save(group: Group)
    fun getSavedGroup(): Group
}