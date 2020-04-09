package com.rv1den.schedule.navigator

import androidx.fragment.app.Fragment

interface FragmentNavigator {
    fun navigateForward(fragment: Fragment)
    fun navigateBack()
}