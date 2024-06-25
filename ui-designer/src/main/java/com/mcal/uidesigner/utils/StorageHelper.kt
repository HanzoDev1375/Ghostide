package com.mcal.uidesigner.utils

import android.os.Environment

object StorageHelper {
    @JvmStatic
    fun getLayoutFilePath(layoutName: String?): String? {
        return if (layoutName != null) {
            getResDirPath() + "/layout/" + layoutName + ".xml"
        } else null
    }

    @JvmStatic
    fun getResDirPath(): String {
        return getProjectPath() + "/res"
    }

    @JvmStatic
    fun getProjectFilepath(): String {
        return getProjectPath() + "/assets/app.xml"
    }

    @JvmStatic
    fun getProjectPath(): String {
        return getSDCardPath() + "/AppProjects/AppWizard"
    }

    @JvmStatic
    fun getDefaultResDirPath(): String {
        return getSDCardPath() + "/AppProjects/Designs/res"
    }

    @JvmStatic
    fun getSDCardPath(): String {
        return Environment.getExternalStorageDirectory().path
    }
}