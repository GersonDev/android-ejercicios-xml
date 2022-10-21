package com.example.android_ejercicios_xml.di

import com.example.android_ejercicios_xml.presentation.activities.main.fragments.second.SecondFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel<SecondFragmentViewModel> {
        SecondFragmentViewModel(get(), get())
    }
}