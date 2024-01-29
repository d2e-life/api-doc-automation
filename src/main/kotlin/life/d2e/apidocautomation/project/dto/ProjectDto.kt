package life.d2e.apidocautomation.project.dto

import java.util.*

data class ProjectDto(
    val id: UUID?,
    val projectName: String?,
    val envs: List<ProjectEnvDto> = mutableListOf()
) {
    constructor(projectName: String) : this(null, projectName, mutableListOf())
    constructor(projectName: String, envs: List<ProjectEnvDto>) : this(null, projectName, envs)
}
