package com.rv1den.schedule.day.view

import com.rv1den.schedule.core.mvp.AbstractMvpFragment
import com.rv1den.schedule.day.R
import com.rv1den.schedule.day.presenter.DayScheduleView
import com.rv1den.schedule.domain.models.values.lesson.Lesson
import kotlinx.android.synthetic.main.fragment_day_schedule.*

class DayScheduleFragment : AbstractMvpFragment(R.layout.fragment_day_schedule), DayScheduleView {

    override fun showSchedule(lessons: List<Lesson>) {
        this.lessons.swapItems(lessons)
    }
}