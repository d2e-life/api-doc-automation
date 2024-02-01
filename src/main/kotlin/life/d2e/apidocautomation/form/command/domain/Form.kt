package life.d2e.apidocautomation.form.command.domain

import jakarta.persistence.*
import life.d2e.apidocautomation.common.PrimaryKeyEntity


@Entity
@Table(name = "ft_form")
class Form(
    formType: String,
    formName: String,
    formFields: MutableList<FormField>
) : PrimaryKeyEntity() {

    @Column(nullable = false)
    var formType: String = formType
        protected set

    @Column(nullable = false)
    var formName: String = formName
        protected set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "form")
    var formFields: MutableList<FormField> = formFields
        protected set

}
