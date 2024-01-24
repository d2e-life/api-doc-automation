package life.d2e.apidocautomation.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "pt_project")
class ProjectDomain(
    projectName: String
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var projectName: String = projectName
    protected set

}