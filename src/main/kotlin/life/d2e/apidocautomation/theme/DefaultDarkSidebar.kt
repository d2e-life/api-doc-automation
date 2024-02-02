package life.d2e.apidocautomation.theme

import java.util.function.Consumer

data class DefaultDarkSidebar(
    val htmlAttributes: MutableMap<String, MutableMap<String, String>>,
    val htmlClasses: MutableMap<String, MutableList<String>>,
    val javascriptFiles: MutableList<String>,
    val cssFiles: MutableList<String>,
    val vendorFiles: MutableList<String>
) : KTLayout {

    override fun addHtmlAttribute(scope: String, attributeName: String, attributeValue: String) {
        val attributes = if (htmlAttributes.containsKey(scope)) {
            htmlAttributes[scope]!!
        } else {
            HashMap()
        }

        attributes[attributeName] = attributeValue
        htmlAttributes[scope] = attributes
    }

    // Add HTML class by scope
    override fun addHtmlClass(scope: String, className: String) {
        val list: MutableList<String> = htmlClasses[scope] ?: mutableListOf()
        list.add(className)
        htmlClasses[scope] = list
    }

    // Print HTML attributes for the HTML template
    override fun printHtmlAttributes(scope: String): String {
        val list: MutableList<String> = ArrayList()
        if (htmlAttributes.containsKey(scope)) {
            htmlAttributes[scope]!!.forEach { (key: String, value: String) ->
                val item = "$key=$value"
                list.add(item)
            }
            return list.joinToString(",")
        }
        return "data-kt-no-attribute='true'"
    }

    // Print HTML classes for the HTML template
    override fun printHtmlClasses(scope: String): String {
        if (htmlClasses.containsKey(scope)) {
            return htmlClasses[scope]!!.joinToString(",")
        }
        return ""
    }

    // Get the global assets
    override fun getGlobalAssets(type: String): List<String> {
        val files = if (type == "Css") settings.assets.css else settings.assets.js
        val newList: MutableList<String> = java.util.ArrayList()

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
    override fun addVendors(vendors: List<String>) {
        for (vendor in vendors) {
            if (!vendorFiles.contains(vendor)) {
                vendorFiles.add(vendor)
            }
        }
    }

    // Add single vendor to the page by name
    override fun addVendor(vendor: String) {
        if (!vendorFiles.contains(vendor)) {
            vendorFiles.add(vendor)
        }
    }

    // Add custom javascript file to the page
    override fun addJavascriptFile(file: String) {
        if (!javascriptFiles.contains(file)) {
            javascriptFiles.add(file)
        }
    }

    // Add custom CSS file to the page
    override fun addCssFile(file: String) {
        if (!cssFiles.contains(file)) {
            cssFiles.add(file)
        }
    }

    // Get vendor files from settings
    override fun getVendors(type: String): List<String> {
        val vendors = settings.vendors
        val files: MutableList<String> = java.util.ArrayList()
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

    override fun getAttributeValue(scope: String, attributeName: String): String? {
        if (htmlAttributes.containsKey(scope)) {
            if (htmlAttributes[scope]!!.containsKey(attributeName)) {
                return htmlAttributes[scope]!![attributeName]
            }
            return ""
        }
        return ""
    }

}
