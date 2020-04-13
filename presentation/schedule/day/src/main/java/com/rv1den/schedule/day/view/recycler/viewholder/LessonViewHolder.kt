package com.rv1den.schedule.day.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rv1den.schedule.domain.models.values.lesson.Lesson
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_item_lesson.view.*

class LessonViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    override val containerView: View? = itemView

    fun bind(lesson: Lesson) {
        itemView.lesson_time_from.text = lesson.lessonDuration.timeFrom
        itemView.lesson_time_to.text = lesson.lessonDuration.timeTo
        itemView.lesson_type.text = lesson.type.value
        itemView.lesson_auditory.text = lesson.auditory.value
        itemView.lesson_name.text = lesson.lessonName.value
        itemView.lesson_teacher_name.text = lesson.teacherName.value
    }
}