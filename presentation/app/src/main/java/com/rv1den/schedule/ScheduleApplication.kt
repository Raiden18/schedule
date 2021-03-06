package com.rv1den.schedule

import android.app.Application
import com.rv1den.schedule.lifecycle.MainActivityLifeCycleCallbacks
import com.rv1den.schedule.provider.dependencies.GlobalDependenciesProviderImpl

class ScheduleApplication : Application() {
    private val globalDependenciesProvider = GlobalDependenciesProviderImpl()

    override fun onCreate() {
        super.onCreate()
        val mainActivityLifeCycleCallback = MainActivityLifeCycleCallbacks(
            globalDependenciesProvider.provideRouter(),
            globalDependenciesProvider.provideFragmentFactory(),
            globalDependenciesProvider.provideFragmentLifecycleCallbacks()
        )
        registerActivityLifecycleCallbacks(mainActivityLifeCycleCallback)
    }
}