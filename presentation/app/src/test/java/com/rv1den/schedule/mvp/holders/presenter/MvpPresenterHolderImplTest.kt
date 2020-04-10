package com.rv1den.schedule.mvp.holders.presenter

import androidx.fragment.app.Fragment
import com.rv1den.schedule.groups.MvpPresenter
import com.rv1den.schedule.mvp.factories.PresenterFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.Before

import org.junit.Test

class MvpPresenterHolderImplTest {
    private lateinit var presenterFactory: PresenterFactory
    private lateinit var presenterHolder: PresenterHolder

    @Before
    fun setUp() {
        presenterFactory = spyk()
        presenterHolder = PresenterHolderImpl(presenterFactory)
    }

    @Test
    fun `Should create presenter if there is no presenter and then return it`() {
        //Given
        val fragment = Fragment::class
        val mvpPresenter: MvpPresenter = mockk()
        every {
            presenterFactory.getPresenter(fragment)
        } returns mvpPresenter

        //When
        val resultPresenter = presenterHolder.getPresenter(fragment)

        //Then
        verify(exactly = 1) {
            presenterFactory.getPresenter(fragment)
        }
        assertEquals(mvpPresenter, resultPresenter)
    }

    @Test
    fun `Should create presenter only once if presenter exists`(){
        //Given
        val fragment = Fragment::class
        val mvpPresenter: MvpPresenter = mockk()
        every {
            presenterFactory.getPresenter(fragment)
        } returns mvpPresenter

        //When
        val resultPresenter = presenterHolder.getPresenter(fragment)
        presenterHolder.getPresenter(fragment)
        presenterHolder.getPresenter(fragment)
        presenterHolder.getPresenter(fragment)

        //Then
        verify(exactly = 1) {
            presenterFactory.getPresenter(fragment)
        }
        assertEquals(mvpPresenter, resultPresenter)
    }

}