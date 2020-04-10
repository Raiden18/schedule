package com.rv1den.schedule.navigation.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface FragmentNavigator {
    fun navigateForward(fragment: Fragment)
    fun navigateBack()
    fun attach(activity: FragmentActivity)
    fun release()
}