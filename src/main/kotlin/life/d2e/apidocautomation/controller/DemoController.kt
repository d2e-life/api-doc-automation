package life.d2e.apidocautomation.controller

import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig
import life.d2e.apidocautomation.theme.KTTheme
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class DemoController(
    val theme: KTTheme,
    val settings: KTThemeBaseConfig,
) {

    @ModelAttribute
    fun themeInit(@CookieValue(name = "sidebar_minimize_state", required = false, defaultValue = "off") sidebarMinimizeState: String) {
        //keep sidebar minimize state for sidebar layouts
        if (settings.defaultLayout.contains("sidebar") && sidebarMinimizeState == "on") {
            theme.addHtmlAttribute("body", "data-kt-app-sidebar-minimize", "on")
            theme.addHtmlAttribute("sidebar-toggle", "data-kt-toggle-state", "active")
            theme.addHtmlClass("sidebar-toggle", "active")
        }
        theme.initLayout()
    }

    @GetMapping("/demo/dashboard")
    fun dashboardDemoPage(): String {
        theme.addVendors(listOf("amcharts", "amcharts-maps", "amcharts-stock"))
        return "pages/dashboards/index"
    }

}
