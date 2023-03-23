package com.example.alarmdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.PowerManager
import android.util.Log

class MyBroadCastReciever:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      try {
          context?.let {
              // Acquire a wake lock to prevent the device from going to sleep
              val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
              val wakeLock = powerManager.newWakeLock(
                  PowerManager.PARTIAL_WAKE_LOCK,
                  "MyApp::MyBroadcastReceiver"
              )
              wakeLock.acquire()

              // Start the Alarm activity using the application context
              val i = Intent(context.applicationContext, Alarm::class.java)
              i.action = "com.example.alarmdemo.ALARM_ACTION"
              i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
              context.applicationContext.startActivity(i)

              Log.i("AlarmReceiver", "Alarm activity started")

              // Release the wake lock
              wakeLock.release()
          }
      }catch (e:Exception){
          Log.i("erroralarm","errrrer")
      }
    }
}