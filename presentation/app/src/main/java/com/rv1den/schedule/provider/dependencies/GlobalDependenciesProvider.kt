package com.rv1den.schedule.provider.dependencies

import androidx.fragment.app.FragmentManager
import com.rv1den.schedule.navigation.factory.FragmentsFactory
import com.rv1den.schedule.navigation.navigation.router.Router

interface GlobalDependenciesProvider {
    fun provideFragmentLifecycleCallbacks(): FragmentManager.FragmentLifecycleCallbacks
    fun provideRouter(): Router
    fun provideFragmentFactory(): FragmentsFactory
}