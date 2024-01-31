package life.d2e.apidocautomation.project.infra

import life.d2e.apidocautomation.project.command.domain.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectRepository : JpaRepository<Project, UUID>
