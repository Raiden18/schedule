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
    lateinit var onGroupClick: (Group) -> Unit
    private val groupsAdapter by lazy {
        GroupsAdapter(onGroupClick)
    }

    init {
        layoutManager = LinearLayoutManager(context)
    }

    fun showGroups(groups: List<Group>) {
        adapter = groupsAdapter
        groupsAdapter.swapItems(groups)
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        if (this.adapter == null) {
            super.setAdapter(adapter)
        }
    }
}