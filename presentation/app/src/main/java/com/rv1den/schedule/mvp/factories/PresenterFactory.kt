package com.rv1den.schedule.mvp.factories

import androidx.fragment.app.Fragment
import com.rv1den.schedule.core.mvp.MvpPresenter
import kotlin.reflect.KClass

interface PresenterFactory {
    fun <T : Fragment> getPresenter(fragmentClass: KClass<T>): MvpPresenter
}