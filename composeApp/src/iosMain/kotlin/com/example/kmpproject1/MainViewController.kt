package com.example.kmpproject1

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmpproject1.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}