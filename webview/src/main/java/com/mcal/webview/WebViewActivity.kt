package com.mcal.webview

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.MenuProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mcal.webview.data.ReactivePreferences
import com.mcal.webview.databinding.ActivityWebviewBinding
import com.mcal.webview.utils.FileReader
import com.mcal.webview.utils.HtmlRenderer
import com.mcal.webview.utils.NetworkHelper.isNetworkAvailable
import kotlinx.coroutines.*

class WebViewActivity : BaseActivity() {
    private lateinit var binding: ActivityWebviewBinding

    private var mHtmlUrl: String? = null
    private var isNightMode = false

    @SuppressLint("SetJavaScriptEnabled")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar(id = R.id.toolbar, title = "Documentation", back = true)
        val webView = binding.webView.apply {
            webViewClient = WebViewClient()
            webChromeClient = ChromeClient(this@WebViewActivity)
        }
        val refresh = binding.refresh
        refresh.setOnRefreshListener {
            refresh()
        }
        intent.extras?.let {
            isNightMode = it.getBoolean(IS_NIGHT_MODE, false)
            it.getString(HTML_URL)?.let { link ->
                mHtmlUrl = link
                val context = this@WebViewActivity
                CoroutineScope(Dispatchers.IO).launch {
                    val async = async {
                        HtmlRenderer.renderHtml(context, FileReader.fromUrl(context, link))
                    }
                    val result = async.await()
                    withContext(Dispatchers.Main) {
                        val finalLink =
                            link + "#googtrans(ru|" + ReactivePreferences.getWebViewLanguage(context) + ")"
                        webView.loadDataWithBaseURL(
                            finalLink, result, "text/html", "UTF-8", finalLink
                        )
                    }
                }
            } ?: run {
                binding.errors.visibility = View.VISIBLE
                binding.errors.text = getString(R.string.webview_invalid_url)
            }
        }

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_webview, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menu_webview_language -> {
                        webViewLanguageDialog()
                        return true
                    }
                    R.id.menu_webview_refresh -> {
                        refresh()
                        return true
                    }
                }
                return false
            }
        })
    }

    override fun onResume() {
        super.onResume()
        binding.errors.visibility = if (!isNetworkAvailable(this)) {
            binding.errors.text = getString(R.string.webview_no_internet_connection)
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val webView = binding.webView
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }

    private fun webViewLanguageDialog() {
        MaterialAlertDialogBuilder(this).apply {
            setItems(
                arrayOf(
                    "عربي",
                    "Deutsch",
                    "English",
                    "Polski",
                    "Русский",
                    "Español",
                    "Français",
                    "Italiano",
                    "Український",
                    "中国人",
                    "中國人",
                    "فارسی" 
                )
            ) { dialogInterface: DialogInterface, p2: Int ->
                val code = when (p2) {
                    AR -> "ar"
                    DE -> "de"
                    EN -> "en"
                    PL -> "pl"
                    ES -> "es"
                    FR -> "fr"
                    IT -> "it"
                    UK -> "uk"
                    ZH_CN -> "zh-CN"
                    ZH_TW -> "zh-TW"
                    Fa_IR -> "fa"
                    
                    else -> {
                        "ru"
                    }
                }
                lifecycleScope.launch {
                    ReactivePreferences.setWebViewLanguage(this@WebViewActivity, code)
                }
                dialogInterface.dismiss()
                refresh()
            }
        }.show()
    }

    fun refresh() {
        val refresh = binding.refresh
        refresh.isRefreshing = true
        recreate()
        refresh.isRefreshing = false
    }

    private class ChromeClient(val activity: WebViewActivity) : WebChromeClient() {
        override fun onReceivedTitle(view: WebView?, title: String?) {
            super.onReceivedTitle(view, title)
            title?.let { activity.setupToolbar(R.id.toolbar, it, back = true) }
        }

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            activity.binding.progressBar.visibility =
                if (newProgress < 100) View.VISIBLE else View.GONE
            activity.binding.progressBar.progress = newProgress
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mHtmlUrl = savedInstanceState?.getString(HTML_URL)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(HTML_URL, mHtmlUrl)
    }

    companion object {
        const val HTML_URL = "htmlUrl"
        const val IS_NIGHT_MODE = "nightMode"
        const val AR = 0
        const val DE = 1
        const val EN = 2
        const val PL = 3
        const val RU = 4
        const val ES = 5
        const val FR = 6
        const val IT = 7
        const val UK = 8
        const val ZH_CN = 9
        const val ZH_TW = 10
        const val Fa_IR = 11
    }
}