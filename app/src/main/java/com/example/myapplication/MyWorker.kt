package com.example.myapplication

import android.content.Context

import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters


class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("RRR", "MyWorker 1 started!")
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
        val data: Data = Data.Builder()
            .putString("keyA", "Hello!")
            .putInt("keyB", 100).build()
        return Result.success(data)
    }
}