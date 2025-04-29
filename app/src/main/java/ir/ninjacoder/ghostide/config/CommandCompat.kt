package ir.ninjacoder.ghostide.config;

import android.content.Context
import java.io.*
import com.xiaoyv.ccompile.utils.*

object CommandCompat {
    fun getBasicCommand(context: Context): String {
        val appLibDirPath = context.applicationInfo.nativeLibraryDir
        val appFileDirPath = context.filesDir.absolutePath
        val pythonBuildDirPath = "$appFileDirPath/files/usr"
        val pythonLibDirPath = "$pythonBuildDirPath/lib"
        val pythonExecName = "libpython3.so"
        val aliasCommand = "alias python=\"$pythonExecName\" && alias pip=\"$pythonExecName -m pip\""

        // Combine the Java and Shell script
        var command = "export PATH=\$PATH:$appLibDirPath:$pythonBuildDirPath && export PYTHONHOME=$pythonBuildDirPath" +
                " && export PYTHONPATH=$appLibDirPath && export LD_LIBRARY_PATH=\$LD_LIBRARY_PATH:$pythonLibDirPath" +
                " && $aliasCommand && clear"

        // Append the sed and echo commands from the shell script
    ///    command += " && sed -i 's@$appFileDirPath@Root@g' $appFileDirPath && echo -e \"\\u001B[31mRoot\\u001B[0m\""
        return command
    }

    fun getInterpreterCommand(context: Context, filePath: String): String {
        val appLibDirPath = context.applicationInfo.nativeLibraryDir
        val appFileDirPath = context.filesDir.absolutePath
        val pythonBuildDirPath = "$appFileDirPath/files/usr"
        val pythonLibDirPath = "$pythonBuildDirPath/lib"
        val pythonExecName = "libpython3.so"
        return "export PATH=\$PATH:$appLibDirPath && export PYTHONHOME=$pythonBuildDirPath && export LD_LIBRARY_PATH=\"\$LD_LIBRARY_PATH:\" && export LD_LIBRARY_PATH=\"\$LD_LIBRARY_PATH${pythonLibDirPath}\" && clear && $pythonExecName $filePath && echo '[Enter to Exit]' && read junk && exit"
    }

    fun getPythonShellCommand(context: Context): String {
        val appLibDirPath = context.applicationInfo.nativeLibraryDir
        val appFileDirPath = context.filesDir.absolutePath
        val pythonBuildDirPath = "$appFileDirPath/files/usr"
        val pythonLibDirPath = "$pythonBuildDirPath/lib"
        return "export PATH=\$PATH:$appLibDirPath && export PYTHONHOME=$pythonBuildDirPath && export PYTHONPATH=$appLibDirPath && export LD_LIBRARY_PATH=\"\$LD_LIBRARY_PATH:\" && export LD_LIBRARY_PATH=\"\$LD_LIBRARY_PATH${pythonLibDirPath}\" && clear && libpython3.so && echo '[Enter to Exit]' && read junk && exit"
    }

  fun getRunPhpCommand(context: Context, phpFile: File): String {
    val appLibDirPath = context.applicationInfo.nativeLibraryDir
    val appFileDirPath = context.filesDir.absolutePath
    val phpLibDirPath = "$appFileDirPath/lib"
    val phpIniPath = File(context.filesDir, "php.ini").path
    
    return """
        export LD_LIBRARY_PATH=\$${""}LD_LIBRARY_PATH:$phpLibDirPath
        "$appLibDirPath/libphp-8.2.8.so" -f "${phpFile.path}" -c "$phpIniPath"
        echo -e '\033[31m[Enter to Exit]\033[0m'
        read junk
        exit
    """.trimIndent().replace("\n", " && ")
}
}