package com.rv1den.schedule.mvp.factories

import androidx.fragment.app.Fragment
import com.rv1den.schedule.core.mvp.MvpPresenter
import com.rv1den.schedule.domain.usecases.group.SaveGroupUseCase
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.domain.usecases.schedule.GetScheduleForSavedGroup
import com.rv1den.schedule.domain.usecases.schedule.SaveSchoolDayUseCase
import com.rv1den.schedule.groups.presenter.GroupsNavigator
import com.rv1den.schedule.groups.presenter.GroupsPresenter
import com.rv1den.schedule.groups.view.GroupsFragment
import com.rv1den.schedule.i_async_framework.AsyncFramework
import com.rv1den.schedule.weeks.presenter.WeeksNavigator
import com.rv1den.schedule.weeks.presenter.WeeksSchedulePresenter
import com.rv1den.schedule.weeks.view.WeeksScheduleFragment
import kotlin.reflect.KClass

class PresenterFactoryImpl(
    private val groupsUseCase: GetGroupsUseCaseImpl,
    private val asyncFramework: AsyncFramework,
    private val saveGroupUseCase: SaveGroupUseCase,
    private val getScheduleForSavedGroup: GetScheduleForSavedGroup,
    private val groupsNavigator: GroupsNavigator,
    private val saveSchoolDayUseCase: SaveSchoolDayUseCase,
    private val weeksNavigator: WeeksNavigator
) : PresenterFactory {
    override fun <T : Fragment> getPresenter(fragmentClass: KClass<T>): MvpPresenter {
        return when (fragmentClass) {
            GroupsFragment::class -> GroupsPresenter(
                asyncFramework,
                groupsUseCase,
                saveGroupUseCase,
                groupsNavigator
            )
            WeeksScheduleFragment::class -> WeeksSchedulePresenter(
                asyncFramework,
                getScheduleForSavedGroup,
                saveSchoolDayUseCase,
                weeksNavigator
            )
            else -> throw IllegalStateException("Unknown fragment class")
        }

    }
}