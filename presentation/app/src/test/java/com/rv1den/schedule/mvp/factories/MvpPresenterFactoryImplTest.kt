package com.rv1den.schedule.mvp.factories

import androidx.fragment.app.Fragment
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.groups.presenter.GroupsPresenter
import com.rv1den.schedule.groups.view.GroupsFragment
import com.rv1den.schedule.i_async_framework.AsyncFramework
import io.mockk.mockk
import io.mockk.spyk
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class MvpPresenterFactoryImplTest {
    private lateinit var getGroupsUseCase: GetGroupsUseCaseImpl
    private lateinit var presenterFactory: PresenterFactory
    private lateinit var asyncFramework: AsyncFramework
    @Before
    fun getPresenter() {
        getGroupsUseCase = mockk(relaxed = true)
        asyncFramework = spyk()
        presenterFactory = PresenterFactoryImpl(getGroupsUseCase, asyncFramework)
    }

    @Test
    fun `Should create presenter for groups fragment`() {
        //Given
        val groupsFragmentClass = GroupsFragment::class

        //When
        val presenter = presenterFactory.getPresenter(groupsFragmentClass)

        //Then
        val isGroupsPresenter = presenter is GroupsPresenter
        assertTrue(isGroupsPresenter)
    }

    @Test(expected = IllegalStateException::class)
    fun `Should throw Illegal exception if there is random fragment`() {
        //Given
        val groupsFragmentClass = Fragment::class

        //When
        presenterFactory.getPresenter(groupsFragmentClass)
    }
}