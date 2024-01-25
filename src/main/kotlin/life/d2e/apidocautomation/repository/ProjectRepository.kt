package life.d2e.apidocautomation.repository

import life.d2e.apidocautomation.domain.HostDomain
import life.d2e.apidocautomation.domain.ProjectDomain
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectRepository : JpaRepository<ProjectDomain, UUID>
interface HostRepository : JpaRepository<HostDomain, UUID>
