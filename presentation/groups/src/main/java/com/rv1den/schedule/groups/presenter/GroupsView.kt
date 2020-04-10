package com.rv1den.schedule.groups.presenter

import com.rv1den.schedule.core.mvp.MvpView
import com.rv1den.schedule.domain.models.enteties.Group

interface GroupsView : MvpView {
    fun showGroups(groups: List<Group>)
    fun showLoader()
    fun hideLoader()
}