package com.rv1den.schedule

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rv1den.schedule.rest_client.facades.GroupsRepositoryRestClientImpl

class MainActivity : AppCompatActivity() {
    private val groupsRepositoryRestClientImpl = GroupsRepositoryRestClientImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        object: AsyncTask<Void?, Void?, Void?>(){
            override fun doInBackground(vararg params: Void?): Void? {
                groupsRepositoryRestClientImpl.getGroups()
                return null
            }
        }.execute()
    }
}
