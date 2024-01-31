package life.d2e.apidocautomation.project.command

import life.d2e.apidocautomation.project.command.application.ProjectRequest
import life.d2e.apidocautomation.project.command.application.ProjectService
import life.d2e.apidocautomation.project.query.dto.ProjectDto
import life.d2e.apidocautomation.project.query.dto.ProjectEnvDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class ProjectTest @Autowired constructor(
    val projectService: ProjectService
) {

    @Test
    fun insertProjectTest() {
        val projectRequest = ProjectRequest(
            "from request",
            listOf(
                ProjectRequest.Environment("dev", "dev.d2e.life"),
                ProjectRequest.Environment("qa", "qa.d2e.life"),
                ProjectRequest.Environment("live", "d2e.life")
            ),
        )
        val result = projectService.insertProject(projectRequest)
        println(result)
    }

    @Test
    fun updateProjectTest() {
        val projectRequest = ProjectRequest(
            "from request changed!!!!",
            listOf(
                ProjectRequest.Environment("dev", "dev.d2e.life"),
                ProjectRequest.Environment("live", "d2e.life")
            ),
        )
        val result = projectService.updateProject(UUID.fromString("018d58cc-b491-eace-a801-1d43b0af1547"), projectRequest)
        println(result)
    }

}
