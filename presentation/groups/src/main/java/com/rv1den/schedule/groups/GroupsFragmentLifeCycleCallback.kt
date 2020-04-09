package com.rv1den.schedule.groups

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class GroupsFragmentLifeCycleCallback : FragmentManager.FragmentLifecycleCallbacks(){
    override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
        super.onFragmentAttached(fm, f, context)


    }
}