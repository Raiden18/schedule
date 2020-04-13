package com.rv1den.schedule.weeks.presenter

import com.rv1den.schedule.core.mvp.AbstractMvpPresenter
import com.rv1den.schedule.domain.models.values.lesson.Lesson
import com.rv1den.schedule.domain.models.values.schedule.Schedule
import com.rv1den.schedule.domain.usecases.schedule.GetScheduleForSavedGroup
import com.rv1den.schedule.domain.usecases.schedule.SaveSchoolDayUseCase
import com.rv1den.schedule.i_async_framework.AsyncFramework

class WeeksSchedulePresenter(
    private val asyncFramework: AsyncFramework,
    private val getScheduleForSavedGroup: GetScheduleForSavedGroup,
    private val saveSchoolDayUseCase: SaveSchoolDayUseCase,
    private val weeksNavigator: WeeksNavigator
) : AbstractMvpPresenter<WeeksScheduleView>() {
    private lateinit var schedule: Schedule

    override fun onViewAttached() {
        asyncFramework.execute(
            onDoTask = getScheduleForSavedGroup::execute,
            onSuccess = ::showSchedule,
            onError = {}
        )
    }

    fun onLessonClick(lesson: Lesson){
        val selectedWeek = schedule.getWeekFor(lesson)
        val selectedDay = selectedWeek.getDayFor(lesson)
        saveSchoolDayUseCase.execute(selectedDay)
        weeksNavigator.openScheduleDetails()
    }

    private fun showSchedule(schedule: Schedule){
        this.schedule = schedule
        mvpView!!.showSchedule(schedule)
    }

    override fun onDestroy() {
        asyncFramework.cancel()
    }
}