package com.mcal.webview.utils

import android.content.Context
import android.util.Log
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.security.ProviderInstaller
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.StandardCharsets
import javax.net.ssl.SSLException


object FileReader {
    fun fromAssets(context: Context, path: String): String {
        return try {
            val sb = StringBuilder()
            val br = BufferedReader(
                InputStreamReader(
                    context.assets.open(path),
                    StandardCharsets.UTF_8
                )
            )
            var line: String?
            while (br.readLine().also { line = it } != null) sb.append(line).append("\n")
            sb.toString()
        } catch (e: Exception) {
            "<p style='color:red;'>Произошла ошибка:</p>" + Log.getStackTraceString(e)
        }
    }

    fun fromUrl(context: Context, url: String): String {
        return try {
            val sb = StringBuilder()
            val br =
                BufferedReader(InputStreamReader(URL(url).openStream(), StandardCharsets.UTF_8))
            var line: String?
            while (br.readLine().also { line = it } != null) sb.append(line).append("\n")
            sb.toString()
        } catch (e: Exception) {
            if (e is SSLException) {
                return try {
                    ProviderInstaller.installIfNeeded(context)
                    fromUrl(context, url)
                } catch (e1: GooglePlayServicesRepairableException) {
                    "<p style='color:red;'>Произошла ошибка:</p>" + Log.getStackTraceString(e1)
                } catch (e1: GooglePlayServicesNotAvailableException) {
                    "<p style='color:red;'>Сервисы Google Play недоступны!</p>"
                }
            }
            "<p style='color:red;'>Произошла ошибка:</p>" + Log.getStackTraceString(e)
        }
    }

    fun fromStorage(path: String): String {
        return try {
            val sb = StringBuilder()
            val br =
                BufferedReader(InputStreamReader(FileInputStream(path), StandardCharsets.UTF_8))
            var line: String?
            while (br.readLine().also { line = it } != null) sb.append(line).append("\n")
            sb.toString()
        } catch (exception: Exception) {
            "<p style='color:red;'>Произошла ошибка:</p>" + Log.getStackTraceString(exception)
        }
    }
}