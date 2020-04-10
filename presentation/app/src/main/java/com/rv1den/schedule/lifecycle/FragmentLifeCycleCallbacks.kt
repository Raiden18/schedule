package com.rv1den.schedule.lifecycle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rv1den.schedule.core.mvp.AbstractMvpFragment
import com.rv1den.schedule.core.mvp.AbstractMvpPresenter
import com.rv1den.schedule.core.mvp.MvpView
import com.rv1den.schedule.mvp.holders.presenter.PresenterHolder

class FragmentLifeCycleCallbacks(
    private val presenterHolder: PresenterHolder
) : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentViewCreated(
        fm: FragmentManager,
        fragment: Fragment,
        v: View,
        savedInstanceState: Bundle?
    ) {
        super.onFragmentViewCreated(fm, fragment, v, savedInstanceState)
        if (fragment is AbstractMvpFragment) {
            val presenter = presenterHolder.getPresenter(fragment::class)
            presenter as AbstractMvpPresenter<MvpView>
            fragment.presener = presenter
            fragment as MvpView
            presenter.attach(fragment)
        }
    }
}