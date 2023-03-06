package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker2(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("RRR", "MyWorker 2 started!")
        val keyA = inputData.getString("keyA")
        val keyB = inputData.getInt("keyB",0)
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
        Log.d("RRR","Result from worker 1: $keyA, $keyB")
        return Result.success()
    }
}