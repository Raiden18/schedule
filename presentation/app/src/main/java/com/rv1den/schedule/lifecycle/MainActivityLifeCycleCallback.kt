package com.rv1den.schedule.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.rv1den.schedule.api.client.RestClientImpl
import com.rv1den.schedule.api.facades.GroupsFacadeRestClientImpl
import com.rv1den.schedule.api.parsers.group.GroupParser
import com.rv1den.schedule.api.parsers.group.GroupParserImpl
import com.rv1den.schedule.api.parsers.groups.GroupsParserImpl
import com.rv1den.schedule.groups.GroupsFragment
import com.rv1den.schedule.navigator.FragmentNavigatorImpl

class MainActivityLifeCycleCallback : Application.ActivityLifecycleCallbacks {

    private val groupParser: GroupParser = GroupParserImpl()
    private val groupsParser = GroupsParserImpl(groupParser)
    private val festClient = RestClientImpl()
    private val groupsRepositoryRestClientImpl = GroupsFacadeRestClientImpl(
        festClient,
        groupsParser
    )
    private val fragmentNavigator = FragmentNavigatorImpl()

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityResumed(activity: Activity) {
        fragmentNavigator.attach(activity as FragmentActivity)
        fragmentNavigator.navigateForward(GroupsFragment())
    }

    override fun onActivityPaused(activity: Activity) {
        fragmentNavigator.release()
    }
}