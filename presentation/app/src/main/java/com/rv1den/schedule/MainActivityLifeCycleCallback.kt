package com.rv1den.schedule

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.rv1den.schedule.navigator.FragmentNavigatorImpl
import com.rv1den.schedule.rest_client.client.RestClientImpl
import com.rv1den.schedule.rest_client.client.factories.bufferedeader.BufferedReaderFactoryImpl
import com.rv1den.schedule.rest_client.client.factories.stringbuilder.StringBuilderFactoryImpl
import com.rv1den.schedule.rest_client.client.factories.urlconnection.UrlConnectionFactoryImpl
import com.rv1den.schedule.rest_client.facades.GroupsRepositoryRestClientImpl
import com.rv1den.schedule.rest_client.parsers.group.GroupParser
import com.rv1den.schedule.rest_client.parsers.group.GroupParserImpl
import com.rv1den.schedule.rest_client.parsers.groups.GroupsParserImpl

class MainActivityLifeCycleCallback : Application.ActivityLifecycleCallbacks {
    private val stringBuilderFactory = StringBuilderFactoryImpl()
    private val bufferedReaderFactory = BufferedReaderFactoryImpl()
    private val urlConnectionFactory = UrlConnectionFactoryImpl()
    private val groupParser: GroupParser = GroupParserImpl()
    private val groupsParser = GroupsParserImpl(groupParser)
    private val festClient = RestClientImpl(
        stringBuilderFactory,
        bufferedReaderFactory,
        urlConnectionFactory
    )
    private val groupsRepositoryRestClientImpl = GroupsRepositoryRestClientImpl(
        festClient,
        groupsParser
    )
    private val fragmentNavigator = FragmentNavigatorImpl()

    override fun onActivityPaused(activity: Activity) {
        fragmentNavigator.release()
    }

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
    }
}