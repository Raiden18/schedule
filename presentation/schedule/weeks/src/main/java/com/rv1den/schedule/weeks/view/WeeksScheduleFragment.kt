package com.rv1den.schedule.weeks.view

import com.rv1den.schedule.core.mvp.AbstractMvpFragment
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import com.rv1den.schedule.weeks.R
import com.rv1den.schedule.weeks.presenter.WeeksSchedulePresenter
import com.rv1den.schedule.weeks.presenter.WeeksScheduleView
import kotlinx.android.synthetic.main.fragment_week_schedule.*

class WeeksScheduleFragment(
) : AbstractMvpFragment(R.layout.fragment_week_schedule), WeeksScheduleView {

    private fun getPresenter(): WeeksSchedulePresenter {
        return presener as WeeksSchedulePresenter
    }

    override fun onPresenterAttached() {
        odd_week.onDayClick = getPresenter()::onLessonClick
        even_week.onDayClick = getPresenter()::onLessonClick
    }

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