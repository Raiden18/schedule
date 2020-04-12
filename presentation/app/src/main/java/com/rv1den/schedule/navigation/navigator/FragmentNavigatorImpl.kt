package com.rv1den.schedule.navigation.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.rv1den.schedule.R

class FragmentNavigatorImpl : FragmentNavigator {
    private var activity: FragmentActivity? = null

    override fun navigateForward(fragment: Fragment) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(R.id.fragment_holder, fragment)
            ?.commitNow()
    }

    override fun navigateBack() {
        activity?.supportFragmentManager
            ?.popBackStack()
    }

    override fun attach(activity: FragmentActivity) {
        this.activity = activity
    }

    override fun release() {
        activity = null
    }
}