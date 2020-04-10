package com.rv1den.schedule.groups.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.groups.R

class GroupsAdapter : RecyclerView.Adapter<GroupViewHolder>() {
    private val products = arrayListOf<Group>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.fragment_group, parent, false)
        return GroupViewHolder(itemView)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val item = products[position]
        holder.bind(item)
    }

    fun swapItems(products: List<Group>){
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}