package com.rv1den.schedule.navigation.navigation.fragments

import com.rv1den.schedule.groups.presenter.GroupsNavigator
import com.rv1den.schedule.navigation.navigation.router.Router
import com.rv1den.schedule.weeks.WeeksScheduleFragment

class GroupsNavigatorImpl(
    private val router: Router
) : GroupsNavigator {

    override fun openWeeksSchedule() {
        val weeksSchedule = WeeksScheduleFragment()
        router.navigateForward(weeksSchedule)
    }
}