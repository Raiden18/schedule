package com.rv1den.schedule.lifecycle

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.rv1den.schedule.navigation.factory.FragmentsFactory
import com.rv1den.schedule.navigation.navigator.FragmentNavigator
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainActivityLifeCycleCallbacksTest {
    private lateinit var fragmentNavigator: FragmentNavigator
    private lateinit var fragmentsFactory: FragmentsFactory
    private lateinit var simpleActivityLifecycleCallbacks: SimpleActivityLifecycleCallbacks
    private lateinit var fragmentLifecycleCallbacks: FragmentManager.FragmentLifecycleCallbacks

    @Before
    fun setUp() {
        fragmentNavigator = spyk()
        fragmentsFactory = spyk()
        fragmentLifecycleCallbacks = spyk()
        simpleActivityLifecycleCallbacks = MainActivityLifeCycleCallbacks(
            fragmentNavigator,
            fragmentsFactory,
            fragmentLifecycleCallbacks
        )
    }

    @Test
    fun `Should open groups fragment when activity was resumed`() {
        //Given
        val fragment: Fragment = mockk(relaxed = true)
        every {
            fragmentsFactory.createGroups()
        } returns fragment
        val fragmentActivity: FragmentActivity = mockk(relaxed = true)
        //When
        simpleActivityLifecycleCallbacks.onActivityResumed(fragmentActivity)

        //Then
        verify(exactly = 1) {
            fragmentNavigator.navigateForward(fragment)
        }
    }

    @Test
    fun `Should attach activity to navigator when activity is resumed`() {
        //Given
        val fragmentActivity: FragmentActivity = mockk(relaxed = true)

        //When
        simpleActivityLifecycleCallbacks.onActivityResumed(fragmentActivity)

        //Then
        verify(exactly = 1) {
            fragmentNavigator.attach(fragmentActivity)
        }
    }

    @Test
    fun `Should release activity from navigator when activity is onPause`() {
        //Given
        val fragmentActivity: FragmentActivity = mockk(relaxed = true)

        //When
        simpleActivityLifecycleCallbacks.onActivityPaused(fragmentActivity)

        //Then
        verify(exactly = 1) {
            fragmentNavigator.release()
        }
    }

    @Test(expected = IllegalStateException::class)
    fun `Should throw IllegalStateException if activity is not FragmentActivity`() {
        //Given
        val activity: Activity = mockk(relaxed = true)

        //When
        simpleActivityLifecycleCallbacks.onActivityResumed(activity)
    }

    @Test
    fun `Should register FragmentLifecycleCallback when activity is created`() {
        //Given
        val fragmentActivity: FragmentActivity = mockk(relaxed = true)
        val fragmentManager: FragmentManager = mockk(relaxed = true)
        every {
            fragmentActivity.supportFragmentManager
        } returns fragmentManager

        //When
        simpleActivityLifecycleCallbacks.onActivityCreated(fragmentActivity, null)

        //Then
        verify(exactly = 1) {
            fragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, true)
        }
    }

    @Test(expected = IllegalStateException::class)
    fun `Should throw IllegalStateException if activity is not FragmentActivity when activity created`() {
        //Given
        val activity: Activity = mockk(relaxed = true)

        //When
        simpleActivityLifecycleCallbacks.onActivityCreated(activity, null)
    }
}