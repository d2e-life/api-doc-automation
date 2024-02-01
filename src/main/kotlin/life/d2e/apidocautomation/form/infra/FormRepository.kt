package life.d2e.apidocautomation.form.infra

import life.d2e.apidocautomation.form.command.domain.Form
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FormRepository : JpaRepository<Form, UUID>
