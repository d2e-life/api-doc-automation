package life.d2e.apidocautomation.repository

import life.d2e.apidocautomation.entity.HostEntity
import life.d2e.apidocautomation.entity.ProjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectRepository : JpaRepository<ProjectEntity, UUID>
interface HostRepository : JpaRepository<HostEntity, UUID>
