package com.prgckwb.stationquiz.screen

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView



@Composable
fun WebViewScreen(url: String?) {
    val openURL = "https://www.google.com/search?q=${url}駅"
    AndroidView(
        factory = {WebView(it)},
        update = { webView ->
            webView.webViewClient = WebViewClient()
            webView.loadUrl(openURL)
        }
    )
}