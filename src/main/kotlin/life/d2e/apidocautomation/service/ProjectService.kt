package life.d2e.apidocautomation.service

import life.d2e.apidocautomation.domain.ProjectDomain
import life.d2e.apidocautomation.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class ProjectService(
    val projectRepository: ProjectRepository
) {

    fun getProjects(): List<ProjectDomain> {
        return projectRepository.findAll()
    }
}