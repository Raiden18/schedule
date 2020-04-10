package com.rv1den.schedule.groups.view

import android.view.View
import com.rv1den.schedule.core.mvp.AbstractMvpFragment
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.groups.R
import com.rv1den.schedule.groups.presenter.GroupsView
import kotlinx.android.synthetic.main.fragment_groups.*

class GroupsFragment : AbstractMvpFragment(R.layout.fragment_groups), GroupsView {

    override fun showGroups(groups: List<Group>) {
        this.groups.showGroups(groups)
    }

    override fun showLoader() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        loader.visibility = View.INVISIBLE
    }
}