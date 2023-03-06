package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button)
        val worker1 = OneTimeWorkRequestBuilder<MyWorker>().build()
        val worker2 = OneTimeWorkRequestBuilder<MyWorker2>().build()
        //val worker = OneTimeWorkRequest.Builder(MyWorker2::class.java).build();

        btn.setOnClickListener {
            WorkManager.getInstance(this)
                .beginWith(worker1)
                .then(worker2)
                .enqueue()
        }
    }
}