package com.rv1den.schedule.groups.view.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rv1den.schedule.domain.models.enteties.Group
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_group.view.*

class GroupViewHolder(
    itemView: View,
    private val onGroupClick: (Group) -> Unit
) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    override val containerView: View? = itemView

    fun bind(group: Group) {
        itemView.setOnClickListener {
            onGroupClick(group)
        }
        itemView.group_title.text = group.groupTitle.value
    }
}