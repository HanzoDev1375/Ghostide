package com.mcal.uidesigner

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.NinePatchDrawable
import android.os.Build
import com.mcal.uidesigner.common.StreamUtilities
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable
import org.w3c.dom.Attr
import org.w3c.dom.DOMException
import org.w3c.dom.Document
import java.io.*
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory

class XmlLayoutResourceFinder(private val context: Context, resDirPath: String?) {
    private val resourcesDir = if (resDirPath == null) null else File(resDirPath)
    private var resourceValues: MutableMap<Int, MutableMap<String, String>>? = null
    private var styleParents: MutableMap<Int, MutableMap<String?, String>>? = null
    private var styles: MutableMap<Int, SortedMap<String?, Map<String, String>>>? = null

    fun reload() {
        resourceValues = HashMap()
        styles = HashMap()
        styleParents = HashMap()
        for (sdk in 0..Build.VERSION.SDK_INT) {
            (styles as HashMap<Int, SortedMap<String?, Map<String, String>>>)[sdk] = TreeMap()
            (styleParents as HashMap<Int, MutableMap<String?, String>>)[sdk] = HashMap()
            (resourceValues as HashMap<Int, MutableMap<String, String>>)[sdk] = HashMap()
        }
        if (resourcesDir != null) {
            loadResources(0, File(resourcesDir, "values"))
            for (sdk in 1..Build.VERSION.SDK_INT) {
                loadResources(sdk, File(resourcesDir, "values-v$sdk"))
            }
        }
    }

    private fun loadResources(sdk: Int, dir: File) {
        try {
            dir.listFiles()?.forEach { xmlFile ->
                if (xmlFile.name.lowercase(Locale.getDefault()).endsWith(".xml")) {
                    val xml = FileInputStream(xmlFile)
                    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml)
                    xml.close()
                    loadStyles(doc, sdk)
                    loadValues(doc, sdk, "string")
                    loadValues(doc, sdk, "color")
                    loadValues(doc, sdk, "dimen")
                    loadValues(doc, sdk, "bool")
                    loadValues(doc, sdk, "integer")
                }
            }
        } catch (th: Throwable) {
            th.printStackTrace()
        }
    }

    private fun loadValues(doc: Document, sdk: Int, tag: String) {
        val nodes = doc.getElementsByTagName(tag)
        for (i in 0 until nodes.length) {
            val node = nodes.item(i)
            val nameNode = node.attributes.getNamedItem("name")
            if (nameNode is Attr) {
                val name = nameNode.value
                resourceValues?.get(sdk)?.set("@$tag/$name", node.textContent)
            }
        }
    }

    @Throws(DOMException::class)
    private fun loadStyles(doc: Document, sdk: Int) {
        val nodes = doc.getElementsByTagName("style")
        for (i in 0 until nodes.length) {
            val node = nodes.item(i)
            val styleNameNode = node.attributes.getNamedItem("name")
            if (styleNameNode is Attr) {
                val styleName = styleNameNode.value
                var parentStyleName = ""
                if (styleName.contains(".")) {
                    parentStyleName = styleName.substring(0, styleName.lastIndexOf(46.toChar()))
                } else {
                    val parentNameNode = node.attributes.getNamedItem("parent")
                    if (parentNameNode is Attr) {
                        parentStyleName = parentNameNode.value
                    }
                }
                styleParents?.get(sdk)?.set(styleName, parentStyleName)
                val attrs: MutableMap<String, String> = HashMap()
                styles?.get(sdk)?.set(styleName, attrs)
                val itemNodes = node.childNodes
                for (j in 0 until itemNodes.length) {
                    val itemNode = itemNodes.item(j)
                    if (itemNode.nodeName == "item") {
                        val itemNameNode = itemNode.attributes.getNamedItem("name")
                        if (itemNameNode is Attr) {
                            attrs[itemNameNode.value] = itemNode.textContent
                        }
                    }
                }
            }
        }
    }

    fun findResourcePropertyValue(value: String?): String? {
        return findUserResourceValue(findUserAttributeValue(value))
    }

    fun findUserResourceValue(rawValue: String?): String? {
        if (rawValue != null && rawValue.startsWith("@")) {
            for (sdk in Build.VERSION.SDK_INT downTo 0) {
                val value = resourceValues?.get(sdk)?.get(rawValue)
                if (value != null) {
                    return value
                }
            }
        }
        return rawValue
    }

    private fun findUserAttributeValue(value: String?): String? {
        var attrName: String? = null
        if (value != null && value.startsWith("?attr/")) {
            attrName = value.substring("?attr/".length)
        } else if (value != null && value.startsWith("?")) {
            attrName = value.substring(1)
        }
        if (attrName != null) {
            for (sdk in Build.VERSION.SDK_INT downTo 0) {
                styles?.get(sdk)?.values?.forEach { values ->
                    if (values.containsKey(attrName)) {
                        return values[attrName]
                    }
                }
            }
        }
        return value
    }

    fun findStyleAttributeValue(
        style: String,
        property: XmlLayoutProperties.PropertySpec
    ): String? {
        return if (style.startsWith("@style/")) {
            findStyleAttributeValue(style.substring("@style/".length), property, HashSet())
        } else null
    }

    private fun findStyleAttributeValue(
        style: String?,
        property: XmlLayoutProperties.PropertySpec,
        visitedStyles: MutableSet<String?>
    ): String? {
        if (visitedStyles.contains(style)) {
            return null
        }
        visitedStyles.add(style)
        for (sdk in Build.VERSION.SDK_INT downTo 0) {
            val attrs = styles?.get(sdk)?.get(style)
            if (attrs != null) {
                return attrs[property.attrName] ?: return findStyleAttributeValue(
                    styleParents?.get(
                        sdk
                    )?.get(style), property, visitedStyles
                )
            }
        }
        return null
    }

    fun findUserDrawable(resName: String?): Drawable? {
        if (!(resourcesDir == null || resName == null || !resName.startsWith("@drawable/"))) {
            val resName2 = resName.substring("@drawable/".length)
            val drawablePngDensity =
                loadImageFile(File(File(resourcesDir, "drawable-$density"), "$resName2.png"))
            if (drawablePngDensity != null) {
                return drawablePngDensity
            }
            val drawableJpgDensity =
                loadImageFile(File(File(resourcesDir, "drawable-$density"), "$resName2.jpg"))
            if (drawableJpgDensity != null) {
                return drawableJpgDensity
            }
            val drawableNineDensity =
                loadNinePatchFile(File(File(resourcesDir, "drawable-$density"), "$resName2.9.png"))
            if (drawableNineDensity != null) {
                return drawableNineDensity
            }
            val drawablePng = loadImageFile(File(File(resourcesDir, "drawable"), "$resName2.png"))
            if (drawablePng != null) {
                return drawablePng
            }
            val drawableJpg = loadImageFile(File(File(resourcesDir, "drawable"), "$resName2.jpg"))
            if (drawableJpg != null) {
                return drawableJpg
            }
            val drawableNine =
                loadNinePatchFile(File(File(resourcesDir, "drawable"), "$resName2.9.png"))
            if (drawableNine != null) {
                return drawableNine
            }
            val vectorDrawable = loadVectorDrawable(
                File(
                    File(resourcesDir, "drawable"),
                    if (resName2.endsWith(".xml")) resName2 else "$resName2.xml"
                )
            )
            if (vectorDrawable != null) {
                return vectorDrawable
            }
            val arrDpi = arrayOf("xxhpdi", "xhdpi", "hdpi", "mdpi", "ldpi")
            val lenDpi = arrDpi.size
            for (i in 0 until lenDpi) {
                val drawable = loadImageFile(
                    File(
                        File(resourcesDir, "drawable-" + arrDpi[i]),
                        "$resName2.png"
                    )
                )
                if (drawable != null) {
                    return drawable
                }
            }
            for (i in 0 until lenDpi) {
                val drawable = loadImageFile(
                    File(
                        File(resourcesDir, "drawable-" + arrDpi[i]),
                        "$resName2.jpg"
                    )
                )
                if (drawable != null) {
                    return drawable
                }
            }
            for (i in 0 until lenDpi) {
                val drawable = loadNinePatchFile(
                    File(
                        File(resourcesDir, "drawable-" + arrDpi[i]),
                        "$resName2.9.png"
                    )
                )
                if (drawable != null) {
                    return drawable
                }
            }
        }
        return null
    }

    private val density: String
        get() = when (context.resources.displayMetrics.densityDpi) {
            120 -> "ldpi"
            160 -> "mdpi"
            240 -> "hdpi"
            320 -> "xhdpi"
            else -> ""
        }

    private fun loadNinePatchFile(imageFile: File?): Drawable? {
        return if (imageFile == null) {
            null
        } else try {
            if (!imageFile.isFile) {
                null
            } else NinePatchDrawable.createFromStream(FileInputStream(imageFile), null)
        } catch (e: Exception) {
            null
        }
    }

    private fun loadVectorDrawable(vectorFile: File?): Drawable? {
        if (vectorFile == null) {
            return null
        }
        try {
            val vectorMasterDrawable = VectorMasterDrawable(context, vectorFile)
            if (vectorMasterDrawable.isVector) {
                return vectorMasterDrawable
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return null
        }
        return null
    }

    private fun loadImageFile(imageFile: File?): Drawable? {
        if (imageFile != null) {
            try {
                if (imageFile.isFile) {
                    val o = BitmapFactory.Options()
                    o.inJustDecodeBounds = true
                    val stream: InputStream = FileInputStream(imageFile)
                    BitmapFactory.decodeStream(stream, null, o)
                    stream.close()
                    var loadedWidth = o.outWidth
                    var loadedHeight = o.outHeight
                    val ratio = loadedWidth.toFloat() / loadedHeight.toFloat()
                    var scale = 1
                    while (loadedWidth / 2 >= 500 || loadedHeight / 2 >= 500) {
                        loadedWidth /= 2
                        loadedHeight /= 2
                        scale *= 2
                    }
                    var width = loadedWidth
                    if (loadedHeight > 500) {
                        width = (500f * ratio).toInt()
                    }
                    if (width > 500) {
                        val height = (500f / ratio).toInt()
                    }
                    val o2 = BitmapFactory.Options()
                    o2.inSampleSize = scale
                    val stream2: InputStream = FileInputStream(imageFile)
                    val bitmap = BitmapFactory.decodeStream(stream2, null, o2)
                    stream2.close()
                    return if (bitmap == null) {
                        null
                    } else BitmapDrawable(context.resources, bitmap)
                }
            } catch (e: Exception) {
                return null
            }
        }
        return null
    }

    val allUserStyles: List<String>
        get() {
            val result: MutableSet<String> = HashSet()
            styles?.values?.forEach { s ->
                for (value in s.keys) {
                    result.add("@style/$value")
                }
            }
            return ArrayList(result)
        }

    val allUserDrawables: List<String>
        get() {
            val result: MutableSet<String> = HashSet()
            if (resourcesDir != null) {
                resourcesDir.listFiles()?.forEach { drawableDir ->
                    if (drawableDir.isDirectory && drawableDir.name.startsWith("drawable")) {
                        drawableDir.listFiles()?.forEach { drawableFile ->
                            val name = drawableFile.name
                            if (name.lowercase(Locale.getDefault())
                                    .endsWith(".png") || name.lowercase(Locale.getDefault())
                                    .endsWith(".jpg") || name.lowercase(Locale.getDefault())
                                    .endsWith(".xml")
                            ) {
                                result.add("@drawable/" + name.substring(0, name.length - 4))
                            }
                        }
                    }
                }
            }
            return ArrayList(result)
        }

    fun getBaseStyle(style: String?): String? {
        if (style == null) {
            return null
        }
        return if (style.startsWith("@style/")) getBaseStyle(
            style.substring("@style/".length),
            HashSet()
        ) else style
    }

    private fun getBaseStyle(style: String, visitedStyles: MutableSet<String>): String? {
        if (visitedStyles.contains(style)) {
            return null
        }
        visitedStyles.add(style)
        for (sdk in Build.VERSION.SDK_INT downTo 0) {
            val parentStyle = styleParents?.get(sdk)?.get(style)
            if (parentStyle != null && parentStyle.isNotEmpty()) {
                return getBaseStyle(parentStyle, visitedStyles)
            }
        }
        return if (style.startsWith("android:")) {
            "@android:style/" + style.substring("android:".length)
        } else "@style/$style"
    }

    fun suggestUserDrawableName(): String {
        for (i in 1..999) {
            if (findUserDrawable("@drawable/image_$i") == null) {
                return "image_$i"
            }
        }
        return "image"
    }

    fun addUserDrawable(name: String, data: Intent) {
        try {
            val dir = File(resourcesDir, "drawable")
            dir.mkdirs()
            data.data?.let {
                StreamUtilities.transfer(
                    context.contentResolver.openInputStream(it),
                    FileOutputStream(File(dir, "$name.png"))
                )
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}