package com.mcal.uidesigner.utils

import android.content.Context
import android.net.Uri
import java.io.*
import java.nio.charset.StandardCharsets

object FileHelper {
    @JvmStatic
    fun readFile(path: String) =
        FileInputStream(File(path)).readBytes().toString(StandardCharsets.UTF_8)

    @JvmStatic
    fun readFile(file: File) =
        FileInputStream(file).readBytes().toString(StandardCharsets.UTF_8)

    @JvmStatic
    fun readFile(inputStream: InputStream) =
        inputStream.readBytes().toString(StandardCharsets.UTF_8)

    @JvmStatic
    fun writeText(path: String, fileContent: String) {
        File(path).writeText(fileContent)
    }

    @JvmStatic
    fun writeText(file: File, fileContent: String) {
        file.writeText(fileContent)
    }

    @JvmStatic
    @Throws(IOException::class)
    fun copyAssetsFile(context: Context, filename: String, output: File) {
        copyFile(context.assets.open(filename), FileOutputStream(output))
    }

    @JvmStatic
    @Throws(IOException::class)
    fun copyFile(source: InputStream, target: OutputStream) {
        val buf = ByteArray(8192)
        var length: Int
        while (source.read(buf).also { length = it } != -1) {
            target.write(buf, 0, length)
        }
    }

    @JvmStatic
    fun getRealFileNameFromUri(context: Context, uri: Uri): String? {
        val path = getRealPathFromUri(context, uri) ?: return null
        return path.substring(path.lastIndexOf("/") + 1)
    }

    @JvmStatic
    fun getRealPathFromUri(context: Context, uri: Uri): String? {
        return when (uri.scheme) {
            "content" -> {
                context.contentResolver.query(uri, arrayOf("_data"), null, null, null)
                    .use { cursor ->
                        cursor?.getColumnIndexOrThrow("_data")?.let { columnIndex ->
                            cursor.moveToFirst()
                            cursor.getString(columnIndex)
                        }
                    }
            }
            "file" -> {
                uri.path
            }
            else -> {
                null
            }
        }
    }

    @JvmStatic
    fun createNewLayoutFile(resDirPath: String, name: String?): String? {
        return createNewLayoutFile(resDirPath, name, "")
    }

    @JvmStatic
    fun createNewLayoutFile(resDirPath: String, name: String?, content: String): String? {
        var name = name
        return try {
            val layoutDir = File(resDirPath, "layout")
            layoutDir.mkdirs()
            if (name == null || name.trim().isEmpty()) {
                name = suggestNewLayoutName(resDirPath)
            }
            var file = File(layoutDir, name)
            if (file.exists()) {
                file = File(layoutDir, suggestNewLayoutName(resDirPath))
            }
            writeText(file, content)
            file.path
        } catch (e: IOException) {
            null
        }
    }

    @JvmStatic
    fun suggestNewLayoutName(resDirPath: String): String {
        val layoutDir = File(resDirPath, "layout")
        layoutDir.mkdirs()
        var i = 1
        while (true) {
            val file = File(layoutDir, "layout$i.xml")
            if (!file.exists()) {
                return file.name
            }
            i++
        }
    }

    @JvmStatic
    fun chooseLayoutOrCreateNew(resDirPath: String): String? {
        val allFiles = File(resDirPath, "layout").listFiles()
        if (allFiles != null) {
            for (f in allFiles) {
                if (f.name.endsWith(".xml")) {
                    return f.path
                }
            }
        }
        return createNewLayoutFile(resDirPath, suggestNewLayoutName(resDirPath))
    }
}