package com.rv1den.schedule.groups.view.recycler.factory

import android.view.ViewGroup
import com.rv1den.schedule.groups.view.recycler.GroupViewHolder

interface ViewHolderFactory {
    fun create(parent: ViewGroup): GroupViewHolder
}