package com.mcal.webview.utils

import android.content.Context
import com.mcal.webview.data.ReactivePreferences

object HtmlRenderer {
    @JvmStatic
    suspend fun renderHtml(context: Context, html: String): String {
        return html
            .replace("<head>", "<head>${style()}")
            .replace(
                "androidstudio.css",
                if (ReactivePreferences.isNightMode())
                    "darkcode.css"
                else "androidstudio.css"
            )
            .replace("<body>", "<body>${translatePlugin(context)}")
            .replace(
                "<body>",
                if (ReactivePreferences.isNightMode()) "<body style='${darkMode()}'>" else "<body>"
            )
    }

    private suspend fun style(): String {
        return StringBuilder().append("<style>@font-face{font-family:CustomFont; src:url(file:///android_asset/JetBrainsMono-Regular.ttf);}")
            .append("p, h1, h2, h3, table, ul, ol {font-size:" + ReactivePreferences.getFontSize() + "; font-family:CustomFont;}")
            .append("pre,code {font-size:" + ReactivePreferences.getFontSize() + "; font-family:CustomFont;}")
            .append(".goog-te-banner-frame{display:none;}")
            .append("")
            .append(darkMode())
            .append("</style>")
            .toString()
    }

    private fun darkMode(): String {
        return if (ReactivePreferences.isNightMode()) {
            "background:#323232; color:#FAFAFA;"
        } else ""
    }

    private fun translatePlugin(context: Context): String {
        return FileReader.fromAssets(context, "translate/google.html")
    }
}
