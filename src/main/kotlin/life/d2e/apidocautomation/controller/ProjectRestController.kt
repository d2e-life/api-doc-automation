package life.d2e.apidocautomation.controller

import life.d2e.apidocautomation.project.command.application.ProjectService
import life.d2e.apidocautomation.project.query.application.ProjectQueryService
import life.d2e.apidocautomation.project.query.dto.ProjectDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProjectRestController(
    val projectService: ProjectService,
    val projectQueryService: ProjectQueryService
) {

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDto> {
        return projectQueryService.getProjects()
    }
}
