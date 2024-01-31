package life.d2e.apidocautomation.project.command.application

data class ProjectRequest(
    val projectName: String,
    val projectEnvironments: List<Environment>
) {
    data class Environment(val environmentName: String, val host: String)
}

