package life.d2e.apidocautomation.project.command.domain

import io.micrometer.common.util.StringUtils
import jakarta.persistence.*
import life.d2e.apidocautomation.api.command.domain.Api
import life.d2e.apidocautomation.common.DomainHandleException
import life.d2e.apidocautomation.common.PrimaryKeyEntity
import life.d2e.apidocautomation.project.query.dto.ProjectDto
import life.d2e.apidocautomation.project.query.dto.ProjectEnvDto


@Entity
@Table(name = "pt_project")
class Project(
    projectName: String,
    environments: MutableList<ProjectEnvironment>
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var projectName: String = projectName
        protected set

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "pt_project_env", joinColumns = [JoinColumn(name = "project_id")], foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var environments: MutableList<ProjectEnvironment> = environments
        protected set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    var apis: MutableList<Api> = mutableListOf()
        protected set

    init {
        validateProjectName(projectName)
        validateProjectEnvironments(environments)
    }

    fun changeProjectName(projectName: String) {
        validateProjectName(projectName)
        this.projectName = projectName
    }

    fun changeEnvironments(environments: MutableList<ProjectEnvironment>) {
        validateProjectEnvironments(environments)
        this.environments = environments
    }

    fun toDto(): ProjectDto {
        return ProjectDto(id, projectName, this.environments.map { ProjectEnvDto(it.environmentName, it.host) })
    }

    private fun validateProjectName(projectName: String) {
        if (StringUtils.isBlank(projectName)) throw DomainHandleException(ProjectError.PROJECT_NAME_INVALID)
    }

    private fun validateProjectEnvironments(environments: MutableList<ProjectEnvironment>) {
        if (environments.isEmpty()) throw DomainHandleException(ProjectError.PROJECT_ENVIRONMENT_EMPTY)
    }

}
