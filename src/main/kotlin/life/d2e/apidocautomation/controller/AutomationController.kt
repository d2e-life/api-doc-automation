package life.d2e.apidocautomation.controller

import life.d2e.apidocautomation.theme.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class AutomationController(
    val ktLayoutWrapper: KTLayoutWrapper
) {

    @ModelAttribute
    fun page(
        model: Model,
        @CookieValue(name = "sidebar_minimize_state", required = false, defaultValue = "off") sidebarMinimizeState: String,
    ) {
        // 여러 layout 을 쓸 이유가 있을까? 프로젝트에서 하나만 쓰는게 나을 것 같음
        val thisPageLayout = "defaultDarkSidebar"
//        val thisPageLayout = "defaultDarkHeader"
//        val thisPageLayout = "defaultLightSidebar"
//        val thisPageLayout = "defaultLightHeader"

        val pageLayout: KTLayout = when (val beanLayout = ktLayoutWrapper.get(thisPageLayout)) {
            is DefaultDarkSidebar -> beanLayout.copy()
            is DefaultDarkHeader -> beanLayout.copy()
            is DefaultLightHeader -> beanLayout.copy()
            is DefaultLightSidebar -> beanLayout.copy()
            else -> (ktLayoutWrapper.defaultDarkSidebar as DefaultDarkSidebar).copy()
        }

        pageLayout.addVendors(listOf("amcharts", "amcharts-maps", "amcharts-stock"))

        //keep sidebar minimize state for sidebar layouts -> javascript 단에서 처리해야하지 않나?
        if (sidebarMinimizeState == "on") {
            pageLayout.addHtmlAttribute("body", "data-kt-app-sidebar-minimize", "on")
            pageLayout.addHtmlAttribute("sidebar-toggle", "data-kt-toggle-state", "active")
            pageLayout.addHtmlClass("sidebar-toggle", "data-kt-toggle-state")
            pageLayout.addHtmlClass("sidebar-toggle", "active")
        }

        model.addAttribute("pageLayout", pageLayout)
    }

    @GetMapping("/dashboard")
    fun dashboardDemoPage(): String {
        return "pages/dashboards/index"
    }

}
