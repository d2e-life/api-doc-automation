package life.d2e.apidocautomation.controller

data class Page(
    var layout: String = "",
    var vendors: MutableList<String> = mutableListOf(),
    var htmlAttributes: MutableMap<String, MutableMap<String, String>> = mutableMapOf(),
    var htmlClasses: MutableMap<String, MutableList<String>> = mutableMapOf(),
)