package ru.shkolny.dnevnik

import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebSettings
import android.view.View
import android.graphics.Color

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(23, 37, 84)
        window.navigationBarColor = Color.rgb(23, 37, 84)
        val webView = WebView(this)
        webView.setBackgroundColor(Color.rgb(244, 247, 251))
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
        webView.settings.allowFileAccess = false
        webView.settings.javaScriptCanOpenWindowsAutomatically = false
        webView.overScrollMode = View.OVER_SCROLL_NEVER
        setContentView(webView)
        webView.loadUrl("file:///android_asset/index.html")
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val webView = (window.decorView.findViewById(android.R.id.content) as? android.view.ViewGroup)
            ?.getChildAt(0) as? WebView
        if (webView != null && webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }
}
