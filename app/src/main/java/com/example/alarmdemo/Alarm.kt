package com.example.alarmdemo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.alarmdemo.R

class Alarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        var mp = MediaPlayer.create(applicationContext, R.raw.amtar)
        mp.start()

        findViewById<Button>(R.id.button2).setOnClickListener {
            mp.stop()
            mp.release()
            finish()
        }
    }
}