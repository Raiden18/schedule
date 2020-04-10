package com.rv1den.schedule.provider.dependencies

import androidx.fragment.app.FragmentManager
import com.rv1den.schedule.navigation.factory.FragmentsFactory
import com.rv1den.schedule.navigation.navigator.FragmentNavigator

interface GlobalDependenciesProvider {
    fun provideFragmentLifecycleCallbacks(): FragmentManager.FragmentLifecycleCallbacks
    fun provideFragmentNavigator(): FragmentNavigator
    fun provideFragmentFactory(): FragmentsFactory
}