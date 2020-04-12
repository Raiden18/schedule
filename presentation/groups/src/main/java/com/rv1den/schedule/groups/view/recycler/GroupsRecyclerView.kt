package com.rv1den.schedule.groups.view.recycler

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.groups.view.recycler.factory.GroupViewHolderFactory
import com.rv1den.schedule.groups.view.recycler.factory.ViewHolderFactory

class GroupsRecyclerView(
    context: Context,
    attributeSet: AttributeSet
) : RecyclerView(context, attributeSet) {
    lateinit var onGroupClick: (Group) -> Unit
    private val viewHolderFactory: ViewHolderFactory by lazy {
        GroupViewHolderFactory(
            LayoutInflater.from(context),
            onGroupClick
        )
    }
    private lateinit var groups: ArrayList<Group>
    private val groupsAdapter by lazy { GroupsAdapter(viewHolderFactory) }

    init {
        layoutManager = LinearLayoutManager(context)
    }

    fun showGroups(groups: List<Group>) {
        adapter = groupsAdapter
        this.groups = ArrayList(groups)
        groupsAdapter.swapItems(groups)
    }


    override fun setAdapter(adapter: Adapter<*>?) {
        if (this.adapter == null) {
            super.setAdapter(adapter)
        }
    }
}