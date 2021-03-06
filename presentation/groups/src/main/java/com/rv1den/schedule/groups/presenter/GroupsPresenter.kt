package com.rv1den.schedule.groups.presenter

import com.rv1den.schedule.core.mvp.AbstractMvpPresenter
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.usecases.group.SaveGroupUseCase
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.i_async_framework.AsyncFramework

class GroupsPresenter(
    private val asyncFramework: AsyncFramework,
    private val getGroupsUseCase: GetGroupsUseCaseImpl,
    private val saveGroupUseCase: SaveGroupUseCase,
    private val groupsNavigator: GroupsNavigator
) : AbstractMvpPresenter<GroupsView>() {

    fun onGroupClick(group: Group) {
        saveGroupUseCase.execute(group)
        groupsNavigator.openWeeksSchedule()
    }

    override fun onViewAttached() {
        loadGroups()
    }

    private fun loadGroups() {
        mvpView?.showLoader()
        asyncFramework.execute(
            onDoTask = getGroupsUseCase::execute,
            onSuccess = ::onSuccess,
            onError = ::showError
        )
    }


    private fun showError(exception: Exception) {
        mvpView?.hideLoader()
    }

    private fun onSuccess(groups: List<Group>) {
        mvpView?.showGroups(groups)
        mvpView?.hideLoader()

    }

    override fun onDestroy() {
        asyncFramework.cancel()
    }
}