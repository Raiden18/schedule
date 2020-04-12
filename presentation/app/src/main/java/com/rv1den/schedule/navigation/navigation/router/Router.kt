package com.rv1den.schedule.navigation.navigation.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface Router {
    fun navigateForward(fragment: Fragment)
    fun navigateBack()
    fun attach(activity: FragmentActivity)
    fun release()
}