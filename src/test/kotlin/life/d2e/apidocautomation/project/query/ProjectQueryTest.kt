package life.d2e.apidocautomation.project.query

import life.d2e.apidocautomation.project.query.application.ProjectQueryService
import life.d2e.apidocautomation.project.query.dto.ProjectDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class ProjectQueryTest @Autowired constructor(
    val projectQueryService: ProjectQueryService
) {

    @Test
    fun getProjectTest() {
        val project: ProjectDto? = projectQueryService.getProject(UUID.fromString("018d5642-cc1b-f38b-a4ea-bfb39cfbb7d8"))
        println(project)
    }

    @Test
    fun getProjectWithHostTest() {
        val project: ProjectDto? = projectQueryService.getProjectWithHost(UUID.fromString("018d5642-cc1b-f38b-a4ea-bfb39cfbb7d8"))
        println(project)
    }

    @Test
    fun getProjectsTest() {
        val projects = projectQueryService.getProjects()
        println(projects)
    }

}
