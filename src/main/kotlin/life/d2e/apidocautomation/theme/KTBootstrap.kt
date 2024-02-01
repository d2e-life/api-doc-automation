package life.d2e.apidocautomation.theme

import life.d2e.apidocautomation.config.properties.KTThemeBaseConfig


class KTBootstrap(private val theme: KTTheme, private val settings: KTThemeBaseConfig) {
    // Global theme initializer
    fun init() {
        initThemeMode()
        initThemeDirection()
        initLayout()
    }

    // Init theme mode option from settings
    fun initThemeMode() {
        theme.setModeSwitch(settings.modeSwitchEnabled)
        theme.modeDefault = settings.modeDefault
    }

    // Init theme direction option (RTL or LTR) from settings
    // Init RTL html attributes by checking if RTL is enabled.
    // This function is being called for the html tag
    fun initThemeDirection() {
        theme.direction = settings.direction

        if (theme.isRtlDirection) {
            theme.addHtmlAttribute("html", "direction", "rtl")
            theme.addHtmlAttribute("html", "dir", "rtl")
            theme.addHtmlAttribute("html", "style", "'direction: rtl'")
        }
    }

    fun initLayout() {
        theme.addHtmlAttribute("body", "id", "kt_app_body")

        theme.layout = settings.defaultLayout
    }

    fun initDarkSidebarLayout() {
        // Layout options
        theme.addHtmlAttribute("body", "data-kt-app-layout", "dark-sidebar")
        theme.addHtmlAttribute("body", "data-kt-app-header-fixed", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-fixed", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-hoverable", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-push-header", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-push-toolbar", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-push-footer", "true")
        theme.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        theme.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        theme.addVendor("datatables")
        theme.addJavascriptFile("js/widgets.bundle.js")
        theme.addJavascriptFile("js/custom/apps/chat/chat.js")
        theme.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        theme.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        theme.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        theme.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initLightSidebarLayout() {
        // Layout options
        theme.addHtmlAttribute("body", "data-kt-app-layout", "light-sidebar")
        theme.addHtmlAttribute("body", "data-kt-app-header-fixed", "false")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-fixed", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-hoverable", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-push-header", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-push-toolbar", "true")
        theme.addHtmlAttribute("body", "data-kt-app-sidebar-push-footer", "true")
        theme.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        theme.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        theme.addVendor("datatables")
        theme.addJavascriptFile("js/widgets.bundle.js")
        theme.addJavascriptFile("js/custom/apps/chat/chat.js")
        theme.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        theme.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        theme.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        theme.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initDarkHeaderLayout() {
        // Layout options
        theme.addHtmlAttribute("body", "data-kt-app-layout", "dark-header")
        theme.addHtmlAttribute("body", "data-kt-app-header-fixed", "true")
        theme.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        theme.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        theme.addVendor("datatables")
        theme.addJavascriptFile("js/widgets.bundle.js")
        theme.addJavascriptFile("js/custom/apps/chat/chat.js")
        theme.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        theme.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        theme.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        theme.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initLightHeaderLayout() {
        // Layout options
        theme.addHtmlAttribute("body", "data-kt-app-layout", "light-header")
        theme.addHtmlAttribute("body", "data-kt-app-header-fixed", "true")
        theme.addHtmlAttribute("body", "data-kt-app-toolbar-enabled", "true")
        theme.addHtmlClass("body", "app-default")

        // Global vendors and javascript files
        theme.addVendor("datatables")
        theme.addJavascriptFile("js/widgets.bundle.js")
        theme.addJavascriptFile("js/custom/apps/chat/chat.js")
        theme.addJavascriptFile("js/custom/utilities/modals/upgrade-plan.js")
        theme.addJavascriptFile("js/custom/utilities/modals/create-app.js")
        theme.addJavascriptFile("js/custom/utilities/modals/users-search.js")
        theme.addJavascriptFile("js/custom/utilities/modals/new-target.js")
    }

    fun initAuthLayout() {
        // Layout options
        theme.addHtmlClass("body", "app-blank")
    }

    fun initSystemLayout() {
        // Layout options
        theme.addHtmlClass("body", "app-black bgi-size-cover bgi-position-center bgi-no-repeat")
    }
}
