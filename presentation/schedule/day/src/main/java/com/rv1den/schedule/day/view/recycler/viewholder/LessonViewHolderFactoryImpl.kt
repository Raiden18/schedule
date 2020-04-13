package com.rv1den.schedule.day.view.recycler.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rv1den.schedule.day.R

class LessonViewHolderFactoryImpl :
    LessonViewHolderFactory {

    override fun create(parent: ViewGroup): LessonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.recycler_item_lesson, parent, false)
        return LessonViewHolder(
            itemView
        )
    }
}