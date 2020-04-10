package com.rv1den.schedule.mvp.factories

import androidx.fragment.app.Fragment
import com.rv1den.schedule.groups.GroupsFragment
import com.rv1den.schedule.groups.Presenter
import com.rv1den.schedule.groups.PresenterImpl
import kotlin.reflect.KClass

class PresenterFactoryImpl : PresenterFactory {

    override fun <T : Fragment> getPresenter(fragmentClass: KClass<T>): Presenter {
        return when (fragmentClass) {
            GroupsFragment::class -> PresenterImpl()
            else -> throw IllegalStateException("Unknown fragment class")
        }

    }
}