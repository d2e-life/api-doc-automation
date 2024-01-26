package life.d2e.apidocautomation.entity

import jakarta.persistence.*

@Entity
@Table(name = "pt_host")
class HostEntity(
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