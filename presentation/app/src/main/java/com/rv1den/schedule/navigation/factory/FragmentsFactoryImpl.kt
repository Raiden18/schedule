package com.rv1den.schedule.navigation.factory

import com.rv1den.schedule.groups.GroupsFragment

class FragmentsFactoryImpl : FragmentsFactory {
    override fun createGroups(): GroupsFragment = GroupsFragment()
}