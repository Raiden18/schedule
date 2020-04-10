package com.rv1den.schedule.core.mvp

abstract class AbstractMvpPresenter<V: MvpView> : MvpPresenter, ViewAttacher<V> {
    protected var mvpView: V? = null

    protected open fun onViewAttached(){

    }

    final override fun attach(mvpView: V) {
        this.mvpView = mvpView
        onViewAttached()
    }

    final override fun detach() {
        mvpView = null
    }
}