package life.d2e.apidocautomation.controller

import life.d2e.apidocautomation.theme.DefaultDarkSidebar
import life.d2e.apidocautomation.theme.KTLayout
import life.d2e.apidocautomation.theme.KTLayoutWrapper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class DemoController(
    val ktLayoutWrapper: KTLayoutWrapper
) {

    @ModelAttribute
    fun page(
        model: Model,
        @CookieValue(name = "sidebar_minimize_state", required = false, defaultValue = "off") sidebarMinimizeState: String,
    ) {
        val defaultDarkSidebar = ktLayoutWrapper.get("defaultDarkSidebar")
        val pageLayout: KTLayout = (defaultDarkSidebar as DefaultDarkSidebar).copy()
        pageLayout.addVendors(listOf("amcharts", "amcharts-maps", "amcharts-stock"))

        //keep sidebar minimize state for sidebar layouts
        if (sidebarMinimizeState == "on") {
            pageLayout.addHtmlAttribute("body", "data-kt-app-sidebar-minimize", "on")
            pageLayout.addHtmlAttribute("sidebar-toggle", "data-kt-toggle-state", "active")
            pageLayout.addHtmlClass("sidebar-toggle", "data-kt-toggle-state")
            pageLayout.addHtmlClass("sidebar-toggle", "active")
        }

        model.addAttribute("pageLayout", pageLayout)
    }

    @GetMapping("/demo/dashboard")
    fun dashboardDemoPage(): String {
        return "pages/dashboards/index"
    }

}
