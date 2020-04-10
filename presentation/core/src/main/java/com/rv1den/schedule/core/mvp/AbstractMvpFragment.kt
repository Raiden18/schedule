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
    override lateinit var presener: MvpPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layouId, container, false)
    }

}