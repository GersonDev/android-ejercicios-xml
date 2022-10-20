package com.example.android_ejercicios_xml.di

import com.example.android_ejercicios_xml.data.datasources.RemoteDataSource
import org.koin.dsl.module

val dataSourcesModule = module {
    single<RemoteDataSource> {
        RemoteDataSource()
    }
}