package life.d2e.apidocautomation.project.command.application

import jakarta.transaction.Transactional
import life.d2e.apidocautomation.project.command.domain.Project
import life.d2e.apidocautomation.project.repository.ProjectRepository
import org.apache.commons.lang3.StringUtils
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectService(
    val projectRepository: ProjectRepository,
) {

    fun insertProject(projectRequest: ProjectRequest): InsertProjectResult {
        if (StringUtils.isBlank(projectRequest.projectName)) {
            InsertProjectResult.ERROR
        }
        val project = Project(projectRequest.projectName)
        projectRepository.save(project)
        return InsertProjectResult.SUCCESS
    }

    @Transactional
    fun updateProject(id: UUID, projectRequest: ProjectRequest): InsertProjectResult {
        val projectEntity = projectRepository.findByIdOrNull(id) ?: return InsertProjectResult.ERROR
        projectEntity.changeProjectName(projectRequest.projectName)
        return InsertProjectResult.SUCCESS
    }

}
