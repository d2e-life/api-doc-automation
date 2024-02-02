package life.d2e.apidocautomation.controller

import life.d2e.apidocautomation.theme.KTLayoutWrapper
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class DemoController(
    val ktLayoutWrapper: KTLayoutWrapper
) {

    @ModelAttribute
    fun page(
        page: Page,
        @CookieValue(name = "sidebar_minimize_state", required = false, defaultValue = "off") sidebarMinimizeState: String,
    ) {
        page.layout = "defaultDarkSidebar"
        page.vendors.addAll(ktLayoutWrapper.get(page.layout).vendorFiles)
        page.vendors.addAll(listOf("amcharts", "amcharts-maps", "amcharts-stock"))

        //keep sidebar minimize state for sidebar layouts
        if (sidebarMinimizeState == "on") {
            page.htmlAttributes["body"] = hashMapOf(Pair("data-kt-app-sidebar-minimize", "on"))
            page.htmlAttributes["sidebar-toggle"] = hashMapOf(Pair("data-kt-toggle-state", "active"))
            page.htmlClasses["sidebar-toggle"] = mutableListOf("sidebar-toggle", "active")
        }
    }

    @GetMapping("/demo/dashboard")
    fun dashboardDemoPage(): String {
        return "pages/dashboards/index"
    }

    @GetMapping("/demo/test")
    fun testDemoPage(): String {
        return "pages/dashboards/test"
    }

}
