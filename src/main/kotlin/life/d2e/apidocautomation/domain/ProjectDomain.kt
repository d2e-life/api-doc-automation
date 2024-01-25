package life.d2e.apidocautomation.domain

import jakarta.persistence.*


@Entity
@Table(name = "pt_project")
class ProjectDomain(
    projectName: String
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var projectName: String = projectName
        protected set

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    protected val mutableHosts: MutableList<HostDomain> = mutableListOf()
    val hosts: List<HostDomain> get() = mutableHosts.toList()

}