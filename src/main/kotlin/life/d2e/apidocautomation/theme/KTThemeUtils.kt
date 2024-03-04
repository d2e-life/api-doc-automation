package life.d2e.apidocautomation.theme

import life.d2e.apidocautomation.config.properties.KTIconsBaseConfig
import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig
import org.apache.commons.lang3.StringUtils

class KTThemeUtils(
    private val ktThemeBaseConfig: KTThemeBaseConfig,
    private val ktIconsBaseConfig: KTIconsBaseConfig
) {

    // Add HTML attributes by scope
    fun getIcon(iconName: String?, iconClass: String, iconType: String): String {

        var iconsFinalClass = ""
        if (StringUtils.isBlank(iconClass)) {
            iconsFinalClass = iconClass
        }

        var _iconType = iconType
        if (StringUtils.isBlank(iconType)) {
            if (ktThemeBaseConfig.iconType.isNotBlank()) {
                _iconType = ktThemeBaseConfig.iconType
            } else {
                _iconType = "outline"
            }
        }

        val output = StringBuilder()
        if (_iconType == "duotone") {
            val paths = ktIconsBaseConfig.iconMap.getOrDefault(iconName, 0)

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

    fun getAssetPath(path: String): String {
        return ktThemeBaseConfig.assetsDir + path
    }

    // Include favicon from settings
    fun getFavicon(): String {
        return getAssetPath(ktThemeBaseConfig.assets.favicon)
    }

    // Include the fonts from settings
    fun getFonts(): List<String> {
        return ktThemeBaseConfig.assets.fonts
    }


}
