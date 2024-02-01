package life.d2e.apidocautomation.api.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.OneToOne
import life.d2e.apidocautomation.form.command.domain.FormField

@Embeddable
class ApiFormFieldChange(formFieldDescChange: String, formField: FormField) {

    @Column(nullable = false)
    var formFieldDescChange: String = formFieldDescChange
        protected set

    @OneToOne
    var formField: FormField = formField
        protected set

}
