package life.d2e.apidocautomation.domain

import jakarta.persistence.*

@Entity
@Table(name = "pt_host")
class HostDomain(
    hostEnv: String,
    host: String,
    project: ProjectDomain
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var hostEnv: String = hostEnv
        protected set

    @Column(nullable = false)
    var host: String = host
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, foreignKey = ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    var project: ProjectDomain = project
        protected set
}