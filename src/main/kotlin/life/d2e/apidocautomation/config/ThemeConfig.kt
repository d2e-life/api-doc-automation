package life.d2e.apidocautomation.config

import life.d2e.apidocautomation.config.properties.KTIconsBaseConfig
import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig
import life.d2e.apidocautomation.theme.KTTheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ThemeConfig {

    @Bean("theme")
    fun theme(settings: KTThemeBaseConfig, iconSettings: KTIconsBaseConfig): KTTheme {
        return KTTheme(settings, iconSettings)
    }
}
