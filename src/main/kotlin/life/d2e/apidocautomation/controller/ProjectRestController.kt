package life.d2e.apidocautomation.controller

import life.d2e.apidocautomation.entity.ProjectEntity
import life.d2e.apidocautomation.service.ProjectService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProjectRestController(val projectService: ProjectService) {

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectEntity> {
        return projectService.getProjects()
    }
}