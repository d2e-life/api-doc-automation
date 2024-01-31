package life.d2e.apidocautomation.project.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class ProjectEnvironment(
    environmentName: String,
    host: String,
) {

    @Column(nullable = false)
    var environmentName: String = environmentName
        protected set

    @Column(nullable = false)
    var host: String = host
        protected set

}
