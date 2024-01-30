package life.d2e.apidocautomation.project.entity

import jakarta.persistence.*
import life.d2e.apidocautomation.common.PrimaryKeyEntity
import life.d2e.apidocautomation.project.dto.ProjectDto
import life.d2e.apidocautomation.project.dto.ProjectEnvDto


@Entity
@Table(name = "pt_project")
class ProjectEntity(
    projectName: String
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var projectName: String = projectName
        protected set

    @OneToMany(mappedBy = "project", cascade = [CascadeType.ALL])
    var envs: MutableList<ProjectEnvEntity> = mutableListOf()
        protected set

    fun changeProjectName(projectName: String) {
        this.projectName = projectName
    }

    fun addEnvs(envs: List<ProjectEnvEntity>) {
        this.envs.addAll(envs)
    }

    fun toDto(): ProjectDto {
        // todo: proxy 객체라면 envs 객체 dto 로 만들지 말아야 함
        return ProjectDto(id, projectName, this.envs.map { ProjectEnvDto(it.id, it.hostEnv, it.host) })
    }

    companion object {
        fun from(projectDto: ProjectDto): ProjectEntity {
            val projectEntity = ProjectEntity(projectDto.projectName!!)
            projectEntity.addEnvs(
                projectDto.envs
                    .map { ProjectEnvEntity(it.host!!, it.hostEnv!!, projectEntity) }
                    .toList()
            )

            return projectEntity
        }
    }


}
