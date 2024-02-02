package life.d2e.apidocautomation.theme


class KTLayoutWrapper(
    val defaultDarkSidebar: KTLayout,
    val defaultDarkHeader: KTLayout,
    val defaultLightSidebar: KTLayout,
    val defaultLightHeader: KTLayout,
    val defaultAuth: KTLayout,
    val defaultSystem: KTLayout,
) {

    fun get(layoutName: String): KTLayout {
        return when (layoutName) {
            "defaultDarkSidebar" -> this.defaultDarkSidebar
            "defaultDarkHeader" -> this.defaultDarkHeader
            "defaultLightSidebar" -> this.defaultLightSidebar
            "defaultLightHeader" -> this.defaultLightHeader
            "defaultAuth" -> this.defaultAuth
            "defaultSystem" -> this.defaultSystem
            else -> this.defaultDarkSidebar
        }
    }

}
