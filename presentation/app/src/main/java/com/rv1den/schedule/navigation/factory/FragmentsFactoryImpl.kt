package com.rv1den.schedule.navigation.factory

import com.rv1den.schedule.groups.view.GroupsFragment

class FragmentsFactoryImpl : FragmentsFactory {
    override fun createGroups(): GroupsFragment = GroupsFragment()
}