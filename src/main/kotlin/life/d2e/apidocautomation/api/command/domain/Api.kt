package life.d2e.apidocautomation.api.command.domain

import jakarta.persistence.*
import life.d2e.apidocautomation.common.PrimaryKeyEntity
import life.d2e.apidocautomation.form.command.domain.FormField
import life.d2e.apidocautomation.project.command.domain.Project

@Entity
@Table(name = "at_api")
class Api(
    apiName: String,
    apiUri: String,
    apiMethod: String,
    apiDesc: String,
    project: Project
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var apiName: String = apiName
        protected set

    @Column(nullable = false)
    var apiUri: String = apiUri
        protected set

    @Column(nullable = false)
    var apiMethod: String = apiMethod
        protected set

    @Column(nullable = true)
    var apiDesc: String = apiDesc
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var project: Project = project
        protected set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "api")
    var apiForms: MutableList<ApiForm> = mutableListOf()
        protected set

}
