package life.d2e.apidocautomation.theme

import life.d2e.apidocautomation.config.properties.KTIconsBaseConfig
import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import java.util.function.Consumer

class KTTheme(
    val settings: KTThemeBaseConfig,
    val iconSettings: KTIconsBaseConfig
) {

    // Theme variables
    var isModeSwitchEnabled: Boolean = false
        private set
    var modeDefault: String = "light"
    var direction: String = "ltr"
    var layout: String? = null
    val htmlAttributes: MutableMap<String, MutableMap<String, String>> = HashMap()
    val htmlClasses: MutableMap<String, MutableList<String>> = HashMap()

    // Keep page level assets
    val javascriptFiles: MutableList<String> = ArrayList()
    val cssFiles: MutableList<String> = ArrayList()
    val vendorFiles: MutableList<String> = ArrayList()

    fun initLayout() {
        val bootstrap = KTBootstrap(this, settings)
        bootstrap.init()
        when (this.layout) {
            "auth" -> bootstrap.initAuthLayout()
            "default-dark-header" -> bootstrap.initDarkHeaderLayout()
            "default-light-header" -> bootstrap.initLightHeaderLayout()
            "default-dark-sidebar" -> bootstrap.initDarkSidebarLayout()
            "default-light-sidebar" -> bootstrap.initLightSidebarLayout()
            "system" -> bootstrap.initSystemLayout()
        }
    }

    // Add HTML attributes by scope
    fun addHtmlAttribute(scope: String, attributeName: String, attributeValue: String) {
        val attributes = if (htmlAttributes.containsKey(scope)) {
            htmlAttributes[scope]!!
        } else {
            HashMap()
        }

        attributes[attributeName] = attributeValue
        htmlAttributes[scope] = attributes
    }

    // Add HTML class by scope
    fun addHtmlClass(scope: String, className: String) {
        val list: MutableList<String> = htmlClasses[scope] ?: mutableListOf()
        list.add(className)
        htmlClasses[scope] = list
    }

    // Print HTML attributes for the HTML template
    fun printHtmlAttributes(scope: String): String {
        val list: MutableList<String> = ArrayList()
        if (htmlAttributes.containsKey(scope)) {
            htmlAttributes[scope]!!.forEach { (key: String, value: String) ->
                val item = "$key=$value"
                list.add(item)
            }
            return list.joinToString(",")
//            return java.lang.String.join(",", list)
        }
        return "data-kt-no-attribute='true'"
    }

    // Print HTML classes for the HTML template
    fun printHtmlClasses(scope: String): String {
        if (htmlClasses.containsKey(scope)) {
            return htmlClasses[scope]!!.joinToString(",")
//            return java.lang.String.join(" ", *htmlClasses[scope])
        }
        return ""
    }

    // Get SVG icon content
    fun getSvgIcon(path: String, classNames: String?): String {
        val svgLines: MutableList<String> = ArrayList()
        try {
            val myObj = File("./src/main/resources/static/assets/media/icons/$path")
            val myReader = Scanner(myObj)
            while (myReader.hasNextLine()) {
                val line = myReader.nextLine()
                svgLines.add(line)
            }
            myReader.close()
        } catch (e: FileNotFoundException) {
            println("$path is not found!")
            e.printStackTrace()
        }

        val output = StringBuilder()

//        output.append("<span class=\"").append(classNames).append("\">")
//        for (line in svgLines) {
//            output.append(line)
//        }
//        output.append("</span>")
//
//        return output.toString()
        return """<span class="$classNames"/></span>"""

    }

    fun getIcon(iconName: String?, iconClass: String, iconType: String): String {

        var iconsFinalClass = ""
        if (StringUtils.isBlank(iconClass)) {
            iconsFinalClass = iconClass
        }

        var _iconType = iconType
        if (StringUtils.isBlank(iconType)) {
            if (settings.iconType.isNotBlank()) {
                _iconType = settings.iconType
            } else {
                _iconType = "outline"
            }
        }

        val output = StringBuilder()
        if (_iconType == "duotone") {
            val paths = iconSettings.iconMap.getOrDefault(iconName, 0)

            output.append("""<i class="ki-$_iconType ki-$iconName $iconsFinalClass">""")
//            output.append("<i class=\"ki-").append(iconType).append(" ki-").append(iconName).append(" ").append(iconsFinalClass).append("\">")
            for (i in 1..paths) {
                output.append("""<span class="path$i"></span>""")
//                output.append("<span class=\"").append("path").append(i).append("\"></span>")
            }
            output.append("</i>")
        } else {
            output.append("<i class=\"ki-").append(_iconType).append(" ki-").append(iconName).append(" ").append(iconsFinalClass).append("\"></i>")
        }

        return output.toString()
    }

    fun getIcon(iconName: String?, iconClass: String): String {
        return getIcon(iconName, iconClass, "")
    }

    fun getIcon(iconName: String?): String {
        return getIcon(iconName, "", "")
    }

    // Set dark mode enabled status
    fun setModeSwitch(flag: Boolean) {
        isModeSwitchEnabled = flag
    }

    val isRtlDirection: Boolean
        // Checks if style direction is RTL
        get() = direction.equals("rtl", ignoreCase = true)

    fun getAssetPath(path: String): String {
        return settings.assetsDir + path
    }

    fun getView(path: String): String {
        return settings.layoutDir + path
    }

    fun getPageView(folder: String, file: String): String {
        return "pages/$folder/$file"
    }

    // Extend CSS file name with RTL
    fun extendCssFilename(path: String): String {
        var _path = path
        if (isRtlDirection) {
            _path = _path.replace(".css", ".rtl.css")
        }

        return _path
    }

    // Include favicon from settings
    fun getFavicon(): String {
        return getAssetPath(settings.assets.favicon)
    }

    // Include the fonts from settings
    fun getFonts(): List<String> {
        return settings.assets.fonts
    }

    // Get the global assets
    fun getGlobalAssets(type: String): List<String> {
        val files = if (type == "Css") settings.assets.css else settings.assets.js
        val newList: MutableList<String> = ArrayList()

        files.forEach(Consumer { file: String ->
            if (type == "Css") {
                newList.add(getAssetPath(extendCssFilename(file)))
            } else {
                newList.add(getAssetPath(file))
            }
        })

        return newList
    }

    // Add multiple vendors to the page by name
    fun addVendors(vendors: List<String>) {
        for (vendor in vendors) {
            if (!vendorFiles.contains(vendor)) {
                vendorFiles.add(vendor)
            }
        }
    }

    // Add single vendor to the page by name
    fun addVendor(vendor: String) {
        if (!vendorFiles.contains(vendor)) {
            vendorFiles.add(vendor)
        }
    }

    // Add custom javascript file to the page
    fun addJavascriptFile(file: String) {
        if (!javascriptFiles.contains(file)) {
            javascriptFiles.add(file)
        }
    }

    // Add custom CSS file to the page
    fun addCssFile(file: String) {
        if (!cssFiles.contains(file)) {
            cssFiles.add(file)
        }
    }

    // Get vendor files from settings
    fun getVendors(type: String): List<String> {
        val vendors = settings.vendors
        val files: MutableList<String> = ArrayList()
        vendorFiles.forEach(Consumer { vendor: String ->
            if (vendors.containsKey(vendor) && vendors[vendor]!!.containsKey(type)) {
                val vendorFiles = vendors[vendor]!![type]!!
                for (file in vendorFiles) {
                    val vendorPath = if (file.contains("https://")) file else getAssetPath(file)
                    files.add(vendorPath)
                }
            }
        })
        return files
    }

    fun getAttributeValue(scope: String, attributeName: String): String? {
        if (htmlAttributes.containsKey(scope)) {
            if (htmlAttributes[scope]!!.containsKey(attributeName)) {
                return htmlAttributes[scope]!![attributeName]
            }
            return ""
        }

        return ""
    }
}
