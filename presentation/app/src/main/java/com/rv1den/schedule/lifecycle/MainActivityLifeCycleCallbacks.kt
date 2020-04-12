package com.rv1den.schedule.lifecycle

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.rv1den.schedule.navigation.factory.FragmentsFactory
import com.rv1den.schedule.navigation.navigator.FragmentNavigator

class MainActivityLifeCycleCallbacks(
    private val fragmentNavigator: FragmentNavigator,
    private val fragmentsFactory: FragmentsFactory,
    private val fragmentLifecycleCallbacks: FragmentManager.FragmentLifecycleCallbacks
) : SimpleActivityLifecycleCallbacks() {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity !is FragmentActivity) throw IllegalStateException("Activity must be child of the FragmentActivity")
        activity.supportFragmentManager
            .registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, true)
    }

    override fun onActivityResumed(activity: Activity) {
        if (activity !is FragmentActivity) throw IllegalStateException("Activity must be child of the FragmentActivity")
        fragmentNavigator.attach(activity)
        val fragmentManager = activity.supportFragmentManager
        if (fragmentManager.backStackEntryCount == 0) {
            setRootScreen()
        }
    }

    override fun onActivityPaused(activity: Activity) {
        fragmentNavigator.release()
    }

    private fun setRootScreen() {
        val rootFragment = fragmentsFactory.createGroups()
        fragmentNavigator.navigateForward(rootFragment)
    }
}