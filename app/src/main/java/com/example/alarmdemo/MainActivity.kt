package com.example.alarmdemo

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val b1: Button = findViewById(R.id.button)
        val e1: EditText = findViewById(R.id.editTextNumber)
        val scheduler = AndroidAlarmScheduler(this)
        var alarmData:alarmData?=null

        b1.setOnClickListener {
            val sec = e1.text.toString().toInt()

            alarmData= alarmData(LocalDateTime.now().plusSeconds(sec.toLong()) )
            alarmData?.let(scheduler::schedule)
//            var i = Intent(applicationContext, MyBroadCastReciever::class.java)
//            var pi = PendingIntent.getBroadcast(applicationContext, 111, i, PendingIntent.FLAG_IMMUTABLE)
//            var am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                am.setExactAndAllowWhileIdle(
//                    AlarmManager.RTC_WAKEUP,
//                    System.currentTimeMillis() + (sec * 1000),
//                    pi
//                )
//            }
//            else {
//                am.setExact(
//                    AlarmManager.RTC_WAKEUP,
//                    System.currentTimeMillis() + (sec * 1000),
//                    pi
//                )
//
//            }
            Toast.makeText(applicationContext, "Alarm set for$sec", Toast.LENGTH_SHORT).show()

        }


    }
}