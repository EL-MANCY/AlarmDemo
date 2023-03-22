package com.example.alarmdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadCastReciever:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            val i = Intent(it, Alarm::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            it.startActivity(i)
        }
    }
}