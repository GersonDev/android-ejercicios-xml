package com.example.android_ejercicios_xml

import android.app.Application
import com.example.android_ejercicios_xml.di.dataSourcesModule
import com.example.android_ejercicios_xml.di.repositoryModule
import com.example.android_ejercicios_xml.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MensajesApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MensajesApplication)
            modules(
                listOf(
                    dataSourcesModule,
                    repositoryModule,
                    viewModelsModule
                )
            )
        }
    }

}