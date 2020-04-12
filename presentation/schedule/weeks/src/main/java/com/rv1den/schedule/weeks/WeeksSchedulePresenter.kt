package com.rv1den.schedule.weeks

import android.util.Log
import com.rv1den.schedule.core.mvp.AbstractMvpPresenter
import com.rv1den.schedule.domain.usecases.schedule.GetScheduleForSavedGroup
import com.rv1den.schedule.i_async_framework.AsyncFramework

class WeeksSchedulePresenter(
    private val asyncFramework: AsyncFramework,
    private val getScheduleForSavedGroup: GetScheduleForSavedGroup
) : AbstractMvpPresenter<WeeksScheduleView>() {

    override fun onViewAttached() {
        asyncFramework.execute(
            onDoTask = getScheduleForSavedGroup::execute,
            onSuccess = { Log.i("HUI", it.toString()) },
            onError = {}
        )
    }

    override fun onDestroy() {

    }
}