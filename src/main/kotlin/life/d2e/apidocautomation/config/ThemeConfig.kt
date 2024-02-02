package life.d2e.apidocautomation.config

import life.d2e.apidocautomation.config.properties.KTIconsBaseConfig
import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig
import life.d2e.apidocautomation.theme.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ThemeConfig {

    @Bean
    fun ktThemeUtils(ktThemeBaseConfig: KTThemeBaseConfig, ktIconsBaseConfig: KTIconsBaseConfig): KTThemeUtils {
        return KTThemeUtils(ktThemeBaseConfig, ktIconsBaseConfig)
    }

    @Bean
    fun ktLayoutWrapper(ktThemeBaseConfig: KTThemeBaseConfig, ktThemeUtils: KTThemeUtils): KTLayoutWrapper {
        val defaultDarkSidebar: KTLayout = DefaultDarkSidebar(ktThemeBaseConfig, ktThemeUtils)
        val defaultDarkHeader: KTLayout = DefaultDarkHeader(ktThemeBaseConfig, ktThemeUtils)
        val defaultLightSidebar: KTLayout = DefaultLightSidebar(ktThemeBaseConfig, ktThemeUtils)
        val defaultLightHeader: KTLayout = DefaultLightHeader(ktThemeBaseConfig, ktThemeUtils)
        val defaultAuth: KTLayout = DefaultAuth(ktThemeBaseConfig, ktThemeUtils)
        val defaultSystem: KTLayout = DefaultSystem(ktThemeBaseConfig, ktThemeUtils)

        return KTLayoutWrapper(
            defaultDarkSidebar = defaultDarkSidebar,
            defaultDarkHeader = defaultDarkHeader,
            defaultLightSidebar = defaultLightSidebar,
            defaultLightHeader = defaultLightHeader,
            defaultAuth = defaultAuth,
            defaultSystem = defaultSystem
        )
    }
}
