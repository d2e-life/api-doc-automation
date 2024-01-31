package life.d2e.apidocautomation.project.query.application

import life.d2e.apidocautomation.project.command.domain.Project
import life.d2e.apidocautomation.project.query.dto.ProjectDto
import life.d2e.apidocautomation.project.infra.ProjectRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectQueryService(
    val projectRepository: ProjectRepository,
) {

    fun getProject(id: UUID): ProjectDto? {
        val project: Project? = projectRepository.findByIdOrNull(id)
        return project?.toDto()
    }

    fun getProjectWithHost(id: UUID): ProjectDto? {
        return projectRepository.findByIdWithHosts(id)?.toDto()
    }

    fun getProjects(): List<ProjectDto> {
        return projectRepository.findAll().map { it.toDto() }.toList()
    }
}
