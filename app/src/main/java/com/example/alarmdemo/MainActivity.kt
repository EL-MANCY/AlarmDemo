package com.example.alarmdemo

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {
    val ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE =111
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + this.packageName)
                )
                startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE)
            } else {
                //Permission Granted-System will work
            }
        }

        val b1: Button = findViewById(R.id.button)
        val e1: EditText = findViewById(R.id.editTextNumber)
        val scheduler = AndroidAlarmScheduler(this)
        var alarmData:alarmData?=null

        b1.setOnClickListener {
            val sec = e1.text.toString().toInt()

            alarmData= alarmData(LocalDateTime.now().plusSeconds(sec.toLong()) )
            alarmData?.let(scheduler::schedule)

            Toast.makeText(applicationContext, "Alarm set for$sec", Toast.LENGTH_SHORT).show()

        }


    }
}