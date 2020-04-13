package com.rv1den.schedule.day.view.recycler.viewholder

import android.view.ViewGroup

interface LessonViewHolderFactory {
    fun create(parent: ViewGroup): LessonViewHolder
}