package com.rv1den.schedule.lifecycle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rv1den.schedule.core.mvp.AbstractMvpPresenter
import com.rv1den.schedule.core.mvp.MvpView
import com.rv1den.schedule.mvp.holders.presenter.PresenterHolder
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before

import org.junit.Test

class FragmentLifeCycleCallbacksTest {
    private lateinit var presenterHolder: PresenterHolder
    private lateinit var presenter: AbstractMvpPresenter<MvpView>
    private lateinit var fragmentLifecycleCallbacks: FragmentLifeCycleCallbacks
    private lateinit var view: View
    private lateinit var fragmentManager: FragmentManager
    private lateinit var savedInstanceState: Bundle
    @Before
    fun setUp() {
        presenterHolder = spyk()
        presenter = spyk()
        view = mockk(relaxed = true)
        fragmentManager = mockk(relaxed = true)
        savedInstanceState = mockk(relaxed = true)
        fragmentLifecycleCallbacks = FragmentLifeCycleCallbacks(presenterHolder)
    }


    @Test
    fun `Should not provide presenter for fragment and not provide view for presenter if the fragment is inherited MvpView`() {
        //Given
        val mvpFragmentTest: Fragment = mockk(relaxed = true)
        every {
            presenterHolder.getPresenter(mvpFragmentTest::class)
        } returns presenter

        //When
        fragmentLifecycleCallbacks.onFragmentViewCreated(
            fragmentManager,
            mvpFragmentTest,
            view,
            savedInstanceState
        )

        //Then
        verify(exactly = 0) {
            presenterHolder.getPresenter(mvpFragmentTest::class)
            presenter.attach(any())
        }
    }

    @Test
    fun `Should provide presenter for fragment and attach view to presetner for the fragment that is inherited MvpView `() {
        //Given
        val mvpFragmentTest: MvpFragmentTest = mockk(relaxed = true)
        every {
            presenterHolder.getPresenter(mvpFragmentTest::class)
        } returns presenter

        //When
        fragmentLifecycleCallbacks.onFragmentViewCreated(
            fragmentManager,
            mvpFragmentTest,
            view,
            savedInstanceState
        )

        //Then
        verify(exactly = 1) {
            mvpFragmentTest.presener = presenter
            presenter.attach(mvpFragmentTest)
        }
    }
}