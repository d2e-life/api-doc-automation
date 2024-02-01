package life.d2e.apidocautomation.api.command.domain

import jakarta.persistence.Embeddable
import jakarta.persistence.OneToOne
import life.d2e.apidocautomation.form.command.domain.FormField

@Embeddable
class ApiFormFieldExclude(formField: FormField) {
    @OneToOne
    var formField: FormField = formField
        protected set
}
