package com.rv1den.schedule.weeks

import com.rv1den.schedule.core.mvp.AbstractMvpFragment
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import kotlinx.android.synthetic.main.fragment_week_schedule.*

class WeeksScheduleFragment(
) : AbstractMvpFragment(R.layout.fragment_week_schedule), WeeksScheduleView {


    override fun showSchedule(schedule: Schedule) {
        odd_week.addSchedule(schedule.oddSchoolWeek)
        even_week.addSchedule(schedule.evenSchoolWeek)
    }

    override fun onDestroyView() {
        odd_week.clearLessonsCells()
        even_week.clearLessonsCells()
        super.onDestroyView()
    }
}