package life.d2e.apidocautomation.api.infra

import life.d2e.apidocautomation.form.command.domain.Form
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ApiRepository : JpaRepository<Form, UUID>
