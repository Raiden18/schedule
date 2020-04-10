package com.rv1den.schedule.mvp.factories

import androidx.fragment.app.Fragment
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCase
import com.rv1den.schedule.groups.GroupsFragment
import com.rv1den.schedule.groups.MvpPresenter
import com.rv1den.schedule.groups.PresenterImpl
import kotlin.reflect.KClass

class PresenterFactoryImpl(
    private val groupsUseCase: GetGroupsUseCase
) : PresenterFactory {

    override fun <T : Fragment> getPresenter(fragmentClass: KClass<T>): MvpPresenter {
        return when (fragmentClass) {
            GroupsFragment::class -> PresenterImpl(groupsUseCase)
            else -> throw IllegalStateException("Unknown fragment class")
        }

    }
}