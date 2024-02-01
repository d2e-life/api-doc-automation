package life.d2e.apidocautomation.config

import life.d2e.apidocautomation.theme.KTTheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ThemeConfig {

    @Bean("theme")
    fun theme(): KTTheme {
        println("테마 초기화!!!!!!!!!!")
        return KTTheme()
    }
}
