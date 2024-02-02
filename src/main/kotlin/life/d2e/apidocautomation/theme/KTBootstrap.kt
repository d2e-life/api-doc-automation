package life.d2e.apidocautomation.theme

import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig


class KTBootstrap(private val ktLayout: KTLayout, private val settings: KTThemeBaseConfig) {
    // Global theme initializer
    fun init() {
        initThemeMode()
        initThemeDirection()
        initLayout()
    }

    // Init theme mode option from settings
    fun initThemeMode() {
        ktLayout.setModeSwitch(settings.modeSwitchEnabled)
        ktLayout.modeDefault = settings.modeDefault
    }

    // Init theme direction option (RTL or LTR) from settings
    // Init RTL html attributes by checking if RTL is enabled.
    // This function is being called for the html tag
    fun initThemeDirection() {
        ktLayout.direction = settings.direction

        if (ktLayout.isRtlDirection) {
            ktLayout.addHtmlAttribute("html", "direction", "rtl")
            ktLayout.addHtmlAttribute("html", "dir", "rtl")
            ktLayout.addHtmlAttribute("html", "style", "'direction: rtl'")
        }
    }

    fun initLayout() {
        ktLayout.addHtmlAttribute("body", "id", "kt_app_body")
        ktLayout.layout = settings.defaultLayout
    }

    fun initDarkSidebarLayout() {
        // Layout options
        ktLayout.addHtmlAttribute("body", "data-kt-app-layout", "dark-sidebar")
        ktLayout.addHtmlAttribute("body", "data-kt-app-header-fixed", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-fixed", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-hoverable", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-push-header", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-push-toolbar", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-push-footer", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        ktLayout.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        ktLayout.addVendor("datatables")
        ktLayout.addJavascriptFile("js/widgets.bundle.js")
        ktLayout.addJavascriptFile("js/custom/apps/chat/chat.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initLightSidebarLayout() {
        // Layout options
        ktLayout.addHtmlAttribute("body", "data-kt-app-layout", "light-sidebar")
        ktLayout.addHtmlAttribute("body", "data-kt-app-header-fixed", "false")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-fixed", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-hoverable", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-push-header", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-push-toolbar", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-sidebar-push-footer", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        ktLayout.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        ktLayout.addVendor("datatables")
        ktLayout.addJavascriptFile("js/widgets.bundle.js")
        ktLayout.addJavascriptFile("js/custom/apps/chat/chat.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initDarkHeaderLayout() {
        // Layout options
        ktLayout.addHtmlAttribute("body", "data-kt-app-layout", "dark-header")
        ktLayout.addHtmlAttribute("body", "data-kt-app-header-fixed", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        ktLayout.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        ktLayout.addVendor("datatables")
        ktLayout.addJavascriptFile("js/widgets.bundle.js")
        ktLayout.addJavascriptFile("js/custom/apps/chat/chat.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initLightHeaderLayout() {
        // Layout options
        ktLayout.addHtmlAttribute("body", "data-kt-app-layout", "light-header")
        ktLayout.addHtmlAttribute("body", "data-kt-app-header-fixed", "true")
        ktLayout.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        ktLayout.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        ktLayout.addVendor("datatables")
        ktLayout.addJavascriptFile("js/widgets.bundle.js")
        ktLayout.addJavascriptFile("js/custom/apps/chat/chat.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        ktLayout.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initAuthLayout() {
        // Layout options
        ktLayout.addHtmlClass("body", "app-blank")
    }

    fun initSystemLayout() {
        // Layout options
        ktLayout.addHtmlClass("body", "app-black bgi-size-cover bgi-position-center bgi-no-repeat")
    }
}
