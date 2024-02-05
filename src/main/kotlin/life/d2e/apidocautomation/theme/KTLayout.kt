package life.d2e.apidocautomation.theme

import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig

interface KTLayout {

    var ktThemeBaseConfig: KTThemeBaseConfig
    var ktThemeUtils: KTThemeUtils
    var modeSwitch: Boolean
    var modeDefault: String
    var direction: String
    var htmlAttributes: MutableMap<String, MutableMap<String, String>>
    var htmlClasses: MutableMap<String, MutableList<String>>
    var javascriptFiles: MutableList<String>
    var cssFiles: MutableList<String>
    var vendorFiles: MutableList<String>

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
        if (htmlAttributes.containsKey(scope)) {
            return htmlAttributes[scope]!!.map { "${it.key}=${it.value}" }.joinToString()
        } else {
            return "data-kt-no-attribute='true'"
        }
    }

    // Print HTML classes for the HTML template
    fun printHtmlClasses(scope: String): String {
        if (htmlClasses.containsKey(scope)) {
            return htmlClasses[scope]!!.joinToString(" ")
        }
        return ""
    }

    // Get the global assets
    fun getGlobalAssets(type: String): List<String> {
        if (type == "Css") {
            if (this.direction == "rtl") {
                return ktThemeBaseConfig.assets.css.map { ktThemeUtils.getAssetPath(it.replace(".css", ".rtl.css")) }.toList()
            }
            return ktThemeBaseConfig.assets.css.map { ktThemeUtils.getAssetPath(it) }.toList()
        } else {
            return ktThemeBaseConfig.assets.js.map { ktThemeUtils.getAssetPath(it) }.toList()
        }
    }

    // Add multiple vendors to the page by name
    fun addVendors(vendors: List<String>) {
        for (vendor in vendors) {
            addVendor(vendor)
        }

    }

    // Add single vendor to the page by name
    fun addVendor(vendor: String) {
        if (!vendorFiles.contains(vendor)) {
            vendorFiles.add(vendor)
        }
    }

    // Get vendor files from settings
    fun getVendors(type: String): List<String> {
        return vendorFiles
            .filter { ktThemeBaseConfig.vendors[it]?.get(type) != null }
            .flatMap { ktThemeBaseConfig.vendors[it]?.get(type)!! }
            .map { if (it.contains("https://")) it else ktThemeUtils.getAssetPath(it) }
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
