package life.d2e.apidocautomation.project.command.application

data class ProjectRequest(
    val projectName: String?,
    val projectEnvironments: List<Environment>?
) {
    constructor(projectName: String?) : this(projectName, null)
    constructor(projectEnvironments: List<Environment>?) : this(null, projectEnvironments)

    data class Environment(val environmentName: String, val host: String)
}

