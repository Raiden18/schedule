package com.rv1den.schedule.groups.view.recycler.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.groups.R
import com.rv1den.schedule.groups.view.recycler.GroupViewHolder

class GroupViewHolderFactory(
    private val layoutInflater: LayoutInflater,
    private val onGroupClick: (Group) -> Unit
): ViewHolderFactory {
    override fun create(parent: ViewGroup): GroupViewHolder {
        val itemView = layoutInflater.inflate(R.layout.fragment_group, parent, false)
        return GroupViewHolder(
            itemView,
            onGroupClick
        )

    }
}