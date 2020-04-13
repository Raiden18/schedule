package com.rv1den.schedule.day.presenter

import com.rv1den.schedule.core.mvp.MvpView
import com.rv1den.schedule.domain.models.values.lesson.Lesson

interface DayScheduleView : MvpView {
    fun showSchedule(lessons: List<Lesson>)
}