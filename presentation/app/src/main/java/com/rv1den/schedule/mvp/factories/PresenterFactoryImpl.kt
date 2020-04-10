package com.rv1den.schedule.mvp.factories

import androidx.fragment.app.Fragment
import com.rv1den.schedule.core.mvp.MvpPresenter
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.groups.presenter.GroupsPresenter
import com.rv1den.schedule.groups.view.GroupsFragment
import com.rv1den.schedule.i_async_framework.AsyncFramework
import kotlin.reflect.KClass

class PresenterFactoryImpl(
    private val groupsUseCase: GetGroupsUseCaseImpl,
    private val asyncFramework: AsyncFramework
) : PresenterFactory {
    override fun <T : Fragment> getPresenter(fragmentClass: KClass<T>): MvpPresenter {
        return when (fragmentClass) {
            GroupsFragment::class -> GroupsPresenter(
                asyncFramework,
                groupsUseCase
            )
            else -> throw IllegalStateException("Unknown fragment class")
        }

    }
}