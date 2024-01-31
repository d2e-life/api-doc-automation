package life.d2e.apidocautomation.project.command.domain

import jakarta.persistence.*
import life.d2e.apidocautomation.common.PrimaryKeyEntity
import life.d2e.apidocautomation.project.query.dto.ProjectDto
import life.d2e.apidocautomation.project.query.dto.ProjectEnvDto


@Entity
@Table(name = "pt_project")
class Project(
    projectName: String
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var projectName: String = projectName
        protected set

    @OneToMany(mappedBy = "project", cascade = [CascadeType.ALL])
    var envs: MutableList<ProjectEnvironment> = mutableListOf()
        protected set

    fun changeProjectName(projectName: String) {
        this.projectName = projectName
    }

    fun addEnvs(envs: List<ProjectEnvironment>) {
        this.envs.addAll(envs)
    }

    fun toDto(): ProjectDto {
        // todo: proxy 객체라면 envs 객체 dto 로 만들지 말아야 함
        return ProjectDto(id, projectName, this.envs.map { ProjectEnvDto(it.id, it.environmentName, it.host) })
    }

    companion object {
        fun from(projectDto: ProjectDto): Project {
            val project = Project(projectDto.projectName!!)
            project.addEnvs(
                projectDto.envs
                    .map { ProjectEnvironment(it.host!!, it.hostEnv!!, project) }
                    .toList()
            )

            return project
        }
    }


}
