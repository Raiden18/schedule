package com.rv1den.schedule.core.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class AbstractMvpFragment(
    @LayoutRes val layouId: Int
) : Fragment(), PresenterRequier {
    override var presener: MvpPresenter? = null
        get() = field
    set(value) {
        field = value
        onPresenterAttached()
    }

    protected open fun onPresenterAttached(){

    }


    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layouId, container, false)
    }

}