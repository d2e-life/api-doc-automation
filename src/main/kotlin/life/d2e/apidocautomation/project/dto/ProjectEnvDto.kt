package life.d2e.apidocautomation.project.dto

import java.util.*

data class ProjectEnvDto(
    val id: UUID?,
    val hostEnv: String?,
    val host: String?
) {
    constructor(hostEnv: String, host: String) : this(null, hostEnv, host)
}
