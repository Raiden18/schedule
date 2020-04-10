package com.rv1den.schedule.mvp.holders.presenter

import androidx.fragment.app.Fragment
import com.rv1den.schedule.groups.MvpPresenter
import com.rv1den.schedule.mvp.factories.PresenterFactory
import kotlin.reflect.KClass

class PresenterHolderImpl(
    private val presenterFactory: PresenterFactory
) : PresenterHolder {
    private val presenterHolder = HashMap<KClass<Fragment>, MvpPresenter>()

    override fun getPresenter(fragmentClass: KClass<Fragment>): MvpPresenter {
        val isPresenterSaved = presenterHolder.containsKey(fragmentClass)
        if (!isPresenterSaved) {
            createPresenterAndSave(fragmentClass)
        }
        return presenterHolder[fragmentClass]!!
    }

    private fun createPresenterAndSave(fragmentClass: KClass<Fragment>) {
        val presenter = presenterFactory.getPresenter(fragmentClass)
        presenterHolder[fragmentClass] = presenter
    }
}