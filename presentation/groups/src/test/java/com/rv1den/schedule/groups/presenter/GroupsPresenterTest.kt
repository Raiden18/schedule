package com.rv1den.schedule.groups.presenter

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.i_async_framework.AsyncFramework
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verifyOrder
import org.junit.Before
import org.junit.Test

class GroupsPresenterTest {
    private lateinit var groupsPresenter: GroupsPresenter
    private lateinit var asyncFramework: AsyncFramework
    private lateinit var getGroupsUseCase: GetGroupsUseCaseImpl
    private lateinit var view: GroupsView
    @Before
    fun setUp() {
        asyncFramework = spyk()
        getGroupsUseCase = mockk(relaxed = true)
        view = spyk()
        groupsPresenter = GroupsPresenter(asyncFramework, getGroupsUseCase)
    }

    @Test
    fun `Should load groups after attaching presenter to view and show them`() {
        //Given
        val groups = listOf<Group>(
            mockk(),
            mockk(),
            mockk(),
            mockk()
        )
        every {
            getGroupsUseCase.execute()
        } returns groups

        every {
            asyncFramework.execute({ getGroupsUseCase.execute() }, any(), any())
        }answers{
            firstArg<() -> List<Group>>().invoke()
            secondArg<(List<Group>) -> Unit>().invoke(groups)
        }

        //When
        groupsPresenter.attach(view)

        //Then
        verifyOrder {
            view.showLoader()
            view.showGroups(groups)
            view.hideLoader()
        }
    }
}