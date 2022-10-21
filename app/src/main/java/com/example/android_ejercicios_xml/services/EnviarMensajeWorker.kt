package com.example.android_ejercicios_xml.services

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android_ejercicios_xml.data.ApiClient
import com.example.android_ejercicios_xml.data.requests.MensajeRequest

class EnviarMensajeWorker(context: Context, workerParameters: WorkerParameters): CoroutineWorker(context, workerParameters) {

    // en teoria aqui corres un proceso pesado
    override suspend fun doWork(): Result {
        val mensaje = inputData.getString("mensaje_llave")
        mensaje?.let {
            ApiClient.getClient().createBrand(
                MensajeRequest(it)
            )
        }
        return Result.success()
    }
}