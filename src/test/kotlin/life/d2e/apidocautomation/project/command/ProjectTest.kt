package life.d2e.apidocautomation.project.command

import life.d2e.apidocautomation.common.DomainHandleException
import life.d2e.apidocautomation.project.command.application.ProjectRequest
import life.d2e.apidocautomation.project.command.application.ProjectService
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
            null,
            listOf(
                ProjectRequest.Environment("dev", "dev.d2e.life"),
                ProjectRequest.Environment("qa", "qa.d2e.life"),
                ProjectRequest.Environment("live", "d2e.life")
            ),
        )
        try {
            val result = projectService.insertProject(projectRequest)
            println(result)
        } catch (e: DomainHandleException) {
            println(e.errorCode)
            println(e.errorCode.getErrorDesc())
        } catch (e: Exception) {
            println(e)
        }
    }

    @Test
    fun changeProjectNameTest() {
        val projectRequest = ProjectRequest("이걸로 바꾼다!")
        projectService.changeProjectName(UUID.fromString("018d5fdd-3541-5b20-b58c-dd185bc755bc"), projectRequest)
    }

    @Test
    fun changeProjectEnvironmentTest() {
        val projectRequest = ProjectRequest(listOf(
            ProjectRequest.Environment("local", "http://localhost:8080"),
            ProjectRequest.Environment("dev", "https://devx-auto.d2e.life"),
        ))
        projectService.changeProjectEnvironment(UUID.fromString("018d5fdd-3541-5b20-b58c-dd185bc755bc"), projectRequest)
    }

}
