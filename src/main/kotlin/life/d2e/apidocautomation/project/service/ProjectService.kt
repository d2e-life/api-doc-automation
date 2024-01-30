package life.d2e.apidocautomation.project.service

import jakarta.transaction.Transactional
import life.d2e.apidocautomation.project.dto.ProjectDto
import life.d2e.apidocautomation.project.entity.ProjectEntity
import life.d2e.apidocautomation.project.repository.ProjectRepository
import life.d2e.apidocautomation.project.resultcode.InsertProjectResult
import org.apache.commons.lang3.StringUtils
import org.hibernate.collection.spi.PersistentBag
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjectService(
    val projectRepository: ProjectRepository,
) {
    fun getProject(id: UUID): ProjectDto? {
        val projectEntity: ProjectEntity? = projectRepository.findByIdOrNull(id)
        return projectEntity?.toDto()
    }

    fun getProjectWithHost(id: UUID): ProjectDto? {
        return projectRepository.findByIdWithHosts(id)?.toDto()
    }

    fun getProjects(): List<ProjectDto> {
        return projectRepository.findAll().map { it.toDto() }.toList()
    }

    fun insertProject(projectDto: ProjectDto): InsertProjectResult {
        if (StringUtils.isBlank(projectDto.projectName)) {
            InsertProjectResult.ERROR
        }
        projectRepository.save(ProjectEntity.from(projectDto))
        return InsertProjectResult.SUCCESS
    }

    @Transactional
    fun updateProject(id: UUID, projectDto: ProjectDto): InsertProjectResult {
        val projectEntity = projectRepository.findByIdOrNull(id) ?: return InsertProjectResult.ERROR
        projectEntity.changeProjectName(projectDto.projectName!!)
        return InsertProjectResult.SUCCESS
    }

}
