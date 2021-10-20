package com.prgckwb.stationquiz.screen

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView



@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(url: String?) {
    val openURL = "https://www.google.com/search?q=${url}駅"
    AndroidView(
        factory = {WebView(it)}
    ) { webView ->
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setGeolocationEnabled(true)
        webView.loadUrl(openURL)
    }
}