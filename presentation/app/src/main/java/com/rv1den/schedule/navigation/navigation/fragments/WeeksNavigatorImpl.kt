package com.rv1den.schedule.navigation.navigation.fragments

import com.rv1den.schedule.navigation.navigation.router.Router
import com.rv1den.schedule.week.WeekScheduleFragment
import com.rv1den.schedule.weeks.presenter.WeeksNavigator

class WeeksNavigatorImpl(
    private val router: Router
) : WeeksNavigator {

    override fun openScheduleDetails() {
        router.navigateForward(WeekScheduleFragment())
    }
}