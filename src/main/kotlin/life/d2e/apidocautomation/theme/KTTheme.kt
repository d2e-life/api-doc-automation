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

    // Keep page level assets
    val javascriptFiles: MutableList<String> = ArrayList()
    val cssFiles: MutableList<String> = ArrayList()

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
            for (i in 1..paths) {
                output.append("""<span class="path$i"></span>""")
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

}
