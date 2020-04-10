package com.rv1den.schedule.mvp.holders.presenter

import androidx.fragment.app.Fragment
import com.rv1den.schedule.groups.Presenter
import kotlin.reflect.KClass

interface PresenterHolder {
    fun getPresenter(fragmentClass: KClass<Fragment>): Presenter
}