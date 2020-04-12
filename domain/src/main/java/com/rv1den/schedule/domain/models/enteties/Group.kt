package com.rv1den.schedule.domain.models.enteties

import com.rv1den.schedule.domain.models.values.group.GroupTitle

data class Group(
    val id: Int,
    val groupTitle: GroupTitle
)