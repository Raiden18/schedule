package com.rv1den.schedule.mvp.holders.presenter

import androidx.fragment.app.Fragment
import com.rv1den.schedule.groups.Presenter
import com.rv1den.schedule.mvp.factories.PresenterFactory
import kotlin.reflect.KClass

class PresenterHolderImpl(
    private val presenterFactory: PresenterFactory
) : PresenterHolder {
    private val presenterHolder = HashMap<KClass<Fragment>, Presenter>()

    override fun getPresenter(fragmentClass: KClass<Fragment>): Presenter {
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