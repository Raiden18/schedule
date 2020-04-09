package com.rv1den.schedule.navigator

import androidx.fragment.app.FragmentActivity

interface ActivityAttacher {
    fun attach(activity: FragmentActivity)
    fun release()
}