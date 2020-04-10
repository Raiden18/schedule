package com.rv1den.schedule

import android.app.Application
import com.rv1den.schedule.lifecycle.MainActivityLifeCycleCallback

class ScheduleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val mainActivityLifeCycleCallback = MainActivityLifeCycleCallback()
        registerActivityLifecycleCallbacks(mainActivityLifeCycleCallback)
    }
}