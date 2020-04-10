package com.rv1den.schedule.provider.dependencies

import com.rv1den.schedule.mvp.holders.presenter.PresenterHolder
import com.rv1den.schedule.navigation.factory.FragmentsFactory
import com.rv1den.schedule.navigation.navigator.FragmentNavigator

interface GlobalDependenciesProvider {
    fun providePresenterHolder(): PresenterHolder
    fun provideFragmentNavigator(): FragmentNavigator
    fun provideFragmentFactory(): FragmentsFactory
}