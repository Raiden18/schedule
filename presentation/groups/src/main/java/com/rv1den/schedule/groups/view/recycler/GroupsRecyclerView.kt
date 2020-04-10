package com.rv1den.schedule.groups.view.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rv1den.schedule.domain.models.enteties.Group

class GroupsRecyclerView(
    context: Context,
    attributeSet: AttributeSet
) : RecyclerView(context, attributeSet) {

    init {
        layoutManager = LinearLayoutManager(context)
    }

    fun showGroups(groups: List<Group>) {
        val groupsAdapter = GroupsAdapter()
        groupsAdapter.swapItems(groups)
        adapter = groupsAdapter
    }
}