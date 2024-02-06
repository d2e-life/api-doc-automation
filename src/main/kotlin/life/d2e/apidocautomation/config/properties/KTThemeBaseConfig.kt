package life.d2e.apidocautomation.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "metronic-settings")
data class KTThemeBaseConfig(
    val name: String,
    val layoutDir: String,
    val direction: String,
    val modeSwitchEnabled: Boolean,
    val modeDefault: String,
    val assetsDir: String,
    val iconType: String,
    val defaultLayout: String,
    val assets: Assets,
    val vendors: List<Vendor>
) {
    data class Assets(
        val favicon: String,
        val fonts: List<String>,
        val css: List<String>,
        val js: List<String>,
    )

    data class Vendor(
        val name: String,
        val css: List<String>?,
        val js: List<String>?,
    )
}
