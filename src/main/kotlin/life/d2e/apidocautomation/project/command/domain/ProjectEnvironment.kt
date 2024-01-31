package life.d2e.apidocautomation.project.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import life.d2e.apidocautomation.common.PrimaryKeyEntity

@Entity
@Table(name = "pt_project_env")
class ProjectEnvironment(
    hostEnv: String,
    host: String,
    project: Project
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var environmentName: String = hostEnv
        protected set

    @Column(nullable = false)
    var host: String = host
        protected set

}
