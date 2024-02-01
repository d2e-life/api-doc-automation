package life.d2e.apidocautomation.api.command.domain

import jakarta.persistence.*
import life.d2e.apidocautomation.common.PrimaryKeyEntity
import life.d2e.apidocautomation.form.command.domain.Form

@Entity
@Table(name = "at_api_form")
class ApiForm(
    api: Api,
    form: Form,
) : PrimaryKeyEntity() {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var api: Api = api
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var form: Form = form
        protected set

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "at_api_form_field_exclude", joinColumns = [JoinColumn(name = "api_form_id")], foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var apiFieldExcludes: MutableSet<ApiFormFieldExclude> = mutableSetOf()
        protected set

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "at_api_form_field_change", joinColumns = [JoinColumn(name = "api_form_id")], foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var apiFieldChanges: MutableSet<ApiFormFieldChange> = mutableSetOf()
        protected set
}
