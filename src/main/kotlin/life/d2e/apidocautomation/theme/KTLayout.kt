package life.d2e.apidocautomation.theme

interface KTLayout {
    fun addHtmlAttribute(scope: String, attributeName: String, attributeValue: String)
    fun addHtmlClass(scope: String, className: String)
    fun printHtmlAttributes(scope: String): String
    fun printHtmlClasses(scope: String)
    fun getGlobalAssets(type: String): List<String>
    fun addVendors(vendors: List<String>)
    fun addVendor(vendor: String)
    fun addJavascriptFile(file: String)
    fun addCssFile(file: String)
    fun getVendors(type: String): List<String>
    fun getAttributeValue(scope: String, attributeName: String): String?
}
