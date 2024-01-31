package life.d2e.apidocautomation.project.infra

import life.d2e.apidocautomation.project.command.domain.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProjectRepository : JpaRepository<Project, UUID> {
    fun findByProjectName(projectName: String): Project

    @Query("SELECT distinct p FROM Project p LEFT JOIN FETCH p.environments where p.id = :id")
    fun findByIdWithHosts(id: UUID): Project?
}
