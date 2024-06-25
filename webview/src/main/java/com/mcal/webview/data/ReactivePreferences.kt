package com.mcal.webview.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object ReactivePreferences {
    private val WEB_LANGUAGE = stringPreferencesKey("webview_language")

    private val Context.prefStore by preferencesDataStore(name = "WebView_DataStore")

    suspend fun getWebViewLanguage(context: Context): String {
        return context.prefStore.data.first()[WEB_LANGUAGE] ?: "ru"
    }

    suspend fun setWebViewLanguage(context: Context, language: String) {
        context.prefStore.edit {
            it[WEB_LANGUAGE] = language
        }
    }

    fun getFontSize(): Int {
        return 14
    }

    fun isNightMode(): Boolean {
        return false
    }
}