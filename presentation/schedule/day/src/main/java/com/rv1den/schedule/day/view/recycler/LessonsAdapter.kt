package com.rv1den.schedule.day.view.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rv1den.schedule.day.view.recycler.viewholder.LessonViewHolder
import com.rv1den.schedule.day.view.recycler.viewholder.LessonViewHolderFactory
import com.rv1den.schedule.domain.models.values.lesson.Lesson

class LessonsAdapter(
    private val lessonViewHolderFactory: LessonViewHolderFactory
) : RecyclerView.Adapter<LessonViewHolder>() {
    private val lessons = arrayListOf<Lesson>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return lessonViewHolderFactory.create(parent)
    }

    override fun getItemCount(): Int = lessons.size

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val item = lessons[position]
        holder.bind(item)
    }

    fun swapItems(lessons: List<Lesson>) {
        this.lessons.clear()
        this.lessons.addAll(lessons)
        notifyDataSetChanged()
    }
}