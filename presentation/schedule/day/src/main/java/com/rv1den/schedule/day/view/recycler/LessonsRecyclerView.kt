package com.rv1den.schedule.day.view.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rv1den.schedule.day.view.recycler.viewholder.LessonViewHolderFactoryImpl
import com.rv1den.schedule.domain.models.values.lesson.Lesson

class LessonsRecyclerView(
    context: Context,
    attributeSet: AttributeSet
) : RecyclerView(context, attributeSet) {
    private val lessonViewHolderFactory = LessonViewHolderFactoryImpl()
    private val lessonsAdapter = LessonsAdapter(lessonViewHolderFactory)

    init {
        layoutManager = LinearLayoutManager(context)
    }

    fun swapItems(lessons: List<Lesson>) {
        adapter = lessonsAdapter
        lessonsAdapter.swapItems(lessons)
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        if (this.adapter == null) {
            super.setAdapter(adapter)
        }
    }
}