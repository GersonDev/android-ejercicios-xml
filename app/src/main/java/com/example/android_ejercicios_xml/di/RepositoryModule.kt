package com.example.android_ejercicios_xml.di

import com.example.android_ejercicios_xml.domain.repositories.MensajesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MensajesRepository> {
        MensajesRepository(get())
    }
}