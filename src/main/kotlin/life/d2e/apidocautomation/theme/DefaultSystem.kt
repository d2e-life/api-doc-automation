package life.d2e.apidocautomation.theme

import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig

data class DefaultSystem(
    override var ktThemeBaseConfig: KTThemeBaseConfig,
    override var ktThemeUtils: KTThemeUtils,
    override var modeSwitch: Boolean,
    override var modeDefault: String,
    override var direction: String,
    override var htmlAttributes: MutableMap<String, MutableMap<String, String>>,
    override var htmlClasses: MutableMap<String, MutableList<String>>,
    override var javascriptFiles: MutableList<String>,
    override var cssFiles: MutableList<String>,
    override var vendorFiles: MutableList<String>,
) : KTLayout {

    constructor(ktThemeBaseConfig: KTThemeBaseConfig, ktThemeUtils: KTThemeUtils) : this(
        ktThemeBaseConfig = ktThemeBaseConfig,
        ktThemeUtils = ktThemeUtils,
        modeSwitch = ktThemeBaseConfig.modeSwitchEnabled,
        modeDefault = ktThemeBaseConfig.modeDefault,
        direction = ktThemeBaseConfig.direction,
        htmlAttributes = mutableMapOf(),
        htmlClasses = mutableMapOf(),
        javascriptFiles = mutableListOf(),
        cssFiles = mutableListOf(),
        vendorFiles = mutableListOf()
    )

    init {
        this.direction = ktThemeBaseConfig.direction
        if (this.direction == "rtl") {
            addHtmlAttribute("html", "direction", "rtl")
            addHtmlAttribute("html", "dir", "rtl")
            addHtmlAttribute("html", "style", "'direction: rtl'")
        }

        addHtmlAttribute("body", "id", "kt_app_body")

        // Layout options
        addHtmlClass("body", "app-black bgi-size-cover bgi-position-center bgi-no-repeat")
    }

}
