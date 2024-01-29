package life.d2e.apidocautomation.project.entity

import jakarta.persistence.*
import life.d2e.apidocautomation.common.PrimaryKeyEntity

@Entity
@Table(name = "pt_project_env")
class ProjectEnvEntity(
    hostEnv: String,
    host: String,
    project: ProjectEntity
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var hostEnv: String = hostEnv
        protected set

    @Column(nullable = false)
    var host: String = host
        protected set

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    var project: ProjectEntity = project
        protected set

}