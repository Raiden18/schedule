package com.rv1den.schedule.mvp.holders.presenter

import androidx.fragment.app.Fragment
import com.rv1den.schedule.core.mvp.MvpPresenter
import com.rv1den.schedule.mvp.factories.PresenterFactory
import kotlin.reflect.KClass

class PresenterHolderImpl(
    private val presenterFactory: PresenterFactory
) : PresenterHolder {
    private val presenterHolder = HashMap<KClass<out Fragment>, MvpPresenter>()

    override fun <T : Fragment> getPresenter(fragmentClass: KClass<T>): MvpPresenter {
        val isPresenterSaved = presenterHolder.containsKey(fragmentClass)
        if (!isPresenterSaved) {
            createPresenterAndSave(fragmentClass)
        }
        return presenterHolder[fragmentClass]!!
    }

    private fun createPresenterAndSave(fragmentClass: KClass<out Fragment>) {
        val presenter = presenterFactory.getPresenter(fragmentClass)
        presenterHolder[fragmentClass] = presenter
    }

    override fun <T : Fragment> remove(fragmentClass: KClass<T>) {
        presenterHolder.remove(fragmentClass)
    }
}