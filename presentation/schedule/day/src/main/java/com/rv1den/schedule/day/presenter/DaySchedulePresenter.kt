package com.rv1den.schedule.day.presenter

import com.rv1den.schedule.core.mvp.AbstractMvpPresenter
import com.rv1den.schedule.domain.usecases.schedule.GetDayScheduleUseCase

class DaySchedulePresenter(
    private val getDayScheduleUseCase: GetDayScheduleUseCase
) : AbstractMvpPresenter<DayScheduleView>() {

    override fun onViewAttached() {
        val day = getDayScheduleUseCase.execute()
        val lessons = listOf(
            day.firstLesson,
            day.secondLesson,
            day.thirdLesson,
            day.fourthLesson,
            day.fifthLesson
        )
        mvpView?.showSchedule(lessons)
    }

    override fun onDestroy() {

    }
}