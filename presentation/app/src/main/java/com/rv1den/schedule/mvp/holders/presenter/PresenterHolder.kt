package com.rv1den.schedule.mvp.holders.presenter

import androidx.fragment.app.Fragment
import com.rv1den.schedule.core.mvp.MvpPresenter
import kotlin.reflect.KClass

interface PresenterHolder {
    fun <T : Fragment> getPresenter(fragmentClass: KClass<T>): MvpPresenter
    fun<T : Fragment> remove(fragmentClass: KClass<T>)
}