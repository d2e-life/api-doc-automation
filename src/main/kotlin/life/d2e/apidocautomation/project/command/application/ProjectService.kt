package life.d2e.apidocautomation.project.command.application

import jakarta.transaction.Transactional
import life.d2e.apidocautomation.common.DomainHandleException
import life.d2e.apidocautomation.project.command.domain.Project
import life.d2e.apidocautomation.project.command.domain.ProjectEnvironment
import life.d2e.apidocautomation.project.command.domain.ProjectError
import life.d2e.apidocautomation.project.infra.ProjectRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectService(
    val projectRepository: ProjectRepository,
) {

    fun insertProject(projectRequest: ProjectRequest): UUID {
        val project = Project(
            projectRequest.projectName ?: throw DomainHandleException(ProjectError.PROJECT_NAME_INVALID),
            projectRequest.projectEnvironments?.map {
                ProjectEnvironment(it.host, it.environmentName)
            }?.toMutableList() ?: throw DomainHandleException(ProjectError.PROJECT_ENVIRONMENT_EMPTY),
        )
        projectRepository.save(project)
        return project.id
    }

    @Transactional
    fun changeProjectName(id: UUID, projectRequest: ProjectRequest) {
        val project = projectRepository.findByIdOrNull(id) ?: throw DomainHandleException(ProjectError.PROJECT_NOT_FOUND)
        project.changeProjectName(projectRequest.projectName ?: throw DomainHandleException(ProjectError.PROJECT_NAME_INVALID))
    }

    @Transactional
    fun changeProjectEnvironment(id: UUID, projectRequest: ProjectRequest) {
        val projectEntity = projectRepository.findByIdOrNull(id) ?: throw DomainHandleException(ProjectError.PROJECT_NOT_FOUND)
        projectEntity.changeEnvironments(
            projectRequest.projectEnvironments?.map {
                ProjectEnvironment(it.environmentName, it.host)
            }?.toMutableList() ?: throw DomainHandleException(ProjectError.PROJECT_ENVIRONMENT_EMPTY)
        )
    }

}
