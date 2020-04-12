package com.rv1den.schedule.weeks

import com.rv1den.schedule.core.mvp.MvpView
import com.rv1den.schedule.domain.models.values.schedule.Schedule

interface WeeksScheduleView : MvpView {
    fun showSchedule(schedule: Schedule)
}