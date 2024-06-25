package com.mcal.uidesigner.utils

import android.graphics.Color
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.reflect.Field

object Utils {
    @JvmStatic
    @Throws(IOException::class)
    fun transfer(inputStream: InputStream, out: OutputStream): Long {
        var size: Long = 0
        val buf = ByteArray(1000)
        while (true) {
            val c = inputStream.read(buf)
            if (c != -1) {
                size += c.toLong()
                out.write(buf, 0, c)
            } else {
                inputStream.close()
                out.close()
                return size
            }
        }
    }

    @JvmStatic
    fun findLayoutFiles(resDirPath: String): MutableList<File> {
        val layoutFiles: MutableList<File> = ArrayList()
        File(resDirPath, "layout").walk().forEach { file ->
            val name = file.name
            if (name.endsWith(".xml")) {
                layoutFiles.add(file)
            }
        }
        layoutFiles.sortWith(Comparator.comparing { obj: File -> obj.name })
        return layoutFiles
    }

    @JvmStatic
    fun toHexColor(color: Int): String {
        return if (Color.alpha(color) == 255) {
            String.format("#%06X", 0xFFFFFF and color)
        } else String.format("#%08X", color)
    }

    @JvmStatic
    fun getAndroidResourceID(clazz: String, resName: String): Int {
        var resName = resName
        val declaredField: Field
        resName = resName.substring(resName.lastIndexOf("/") + 1)
        try {
            declaredField = Class.forName(clazz).getField(resName)
            declaredField.isAccessible = true
            return declaredField.getInt(null)
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        return 0
    }
}