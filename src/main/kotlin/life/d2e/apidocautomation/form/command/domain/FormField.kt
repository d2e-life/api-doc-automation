package life.d2e.apidocautomation.form.command.domain

import jakarta.persistence.*
import life.d2e.apidocautomation.common.PrimaryKeyEntity

@Entity
@Table(name = "ft_form_field")
class FormField(
    formFieldType: String,
    formFieldName: String,
    formFieldDesc: String,
    form: Form,
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var formFieldType: String = formFieldType
        protected set

    @Column(nullable = false)
    var formFieldName: String = formFieldName
        protected set

    @Column(nullable = true)
    var formFieldDesc: String = formFieldDesc
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var form: Form = form
        protected set

}
