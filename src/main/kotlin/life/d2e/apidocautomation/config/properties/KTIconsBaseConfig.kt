package life.d2e.apidocautomation.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "metronic-icons")
data class KTIconsBaseConfig(
    val iconMap: Map<String, Int>
)
