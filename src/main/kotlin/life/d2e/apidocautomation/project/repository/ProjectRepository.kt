package life.d2e.apidocautomation.project.repository

import life.d2e.apidocautomation.project.entity.ProjectEnvEntity
import life.d2e.apidocautomation.project.entity.ProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProjectRepository : JpaRepository<ProjectEntity, UUID> {
    fun findByProjectName(projectName: String) : ProjectEntity

    @Query("SELECT distinct p FROM ProjectEntity p LEFT JOIN FETCH p.envs where p.id = :id")
    fun findByIdWithHosts(id: UUID) : ProjectEntity?
}
interface ProjectEnvRepository : JpaRepository<ProjectEnvEntity, UUID>
