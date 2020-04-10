package com.rv1den.schedule.lifecycle

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.rv1den.schedule.navigation.factory.FragmentsFactory
import com.rv1den.schedule.navigation.navigator.FragmentNavigator

class MainActivityLifeCycleCallback(
    private val fragmentNavigator: FragmentNavigator,
    private val fragmentsFactory: FragmentsFactory
) : SimpleActivityLifecycleCallbacks() {

    override fun onActivityResumed(activity: Activity) {
        if (activity !is FragmentActivity) throw IllegalStateException("Activity must be child of the FragmentActivity")
        fragmentNavigator.attach(activity)
        setRootScreen()
    }

    override fun onActivityPaused(activity: Activity) {
        fragmentNavigator.release()
    }

    private fun setRootScreen() {
        val rootFragment = fragmentsFactory.createGroups()
        fragmentNavigator.navigateForward(rootFragment)
    }
}