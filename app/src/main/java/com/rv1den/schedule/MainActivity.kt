package com.rv1den.schedule

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rv1den.schedule.rest_client.client.RestClientImpl
import com.rv1den.schedule.rest_client.client.factories.bufferedeader.BufferedReaderFactoryImpl
import com.rv1den.schedule.rest_client.client.factories.stringbuilder.StringBuilderFactoryImpl
import com.rv1den.schedule.rest_client.client.factories.urlconnection.UrlConnectionFactoryImpl
import com.rv1den.schedule.rest_client.facades.GroupsRepositoryRestClientImpl

class MainActivity : AppCompatActivity() {
    private val stringBuilderFactory = StringBuilderFactoryImpl()
    private val bufferedReaderFactory = BufferedReaderFactoryImpl()
    private val urlConnectionFactory = UrlConnectionFactoryImpl()
    private val festClient = RestClientImpl(
        stringBuilderFactory,
        bufferedReaderFactory,
        urlConnectionFactory
    )
    private val groupsRepositoryRestClientImpl = GroupsRepositoryRestClientImpl(festClient)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        object : AsyncTask<Void?, Void?, Void?>() {
            override fun doInBackground(vararg params: Void?): Void? {
                groupsRepositoryRestClientImpl.getGroups()
                return null
            }
        }.execute()
    }
}
