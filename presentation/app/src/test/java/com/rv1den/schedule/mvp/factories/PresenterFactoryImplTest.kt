package com.rv1den.schedule.mvp.factories

import androidx.fragment.app.Fragment
import com.rv1den.schedule.groups.GroupsFragment
import com.rv1den.schedule.groups.PresenterImpl
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PresenterFactoryImplTest {
    private lateinit var presenterFactory: PresenterFactory

    @Before
    fun getPresenter() {
        presenterFactory = PresenterFactoryImpl()
    }

    @Test
    fun `Should create presenter for groups fragment`() {
        //Given
        val groupsFragmentClass = GroupsFragment::class

        //When
        val presenter = presenterFactory.getPresenter(groupsFragmentClass)

        //Then
        val isGroupsPresenter = presenter is PresenterImpl
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