package life.d2e.apidocautomation.entity

import jakarta.persistence.*


@Entity
@Table(name = "pt_project")
class ProjectEntity(
    projectName: String
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var projectName: String = projectName
        protected set

    @OneToMany(mappedBy = "project", cascade = [CascadeType.ALL])
    protected val mutableHosts: MutableList<HostEntity> = mutableListOf()
    val hosts: List<HostEntity> get() = mutableHosts.toList()

}