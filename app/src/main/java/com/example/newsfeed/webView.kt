package com.example.newsfeed

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class webView : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        toolbar = findViewById(R.id.toolbar)
        webView = findViewById(R.id.webview)
        setSupportActionBar(toolbar)
        val intent = intent
        val url = intent.getStringExtra("url")
        webView?.setWebViewClient(WebViewClient())
        webView?.loadUrl(url!!)
    }
}