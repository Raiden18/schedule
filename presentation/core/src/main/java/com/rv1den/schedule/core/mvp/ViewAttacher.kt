package com.rv1den.schedule.core.mvp

interface ViewAttacher<V: MvpView> {
    fun attach(mvpView: V)
    fun detach()
}