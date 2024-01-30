package life.d2e.apidocautomation

import life.d2e.apidocautomation.project.dto.ProjectDto
import life.d2e.apidocautomation.project.dto.ProjectEnvDto
import life.d2e.apidocautomation.project.service.ProjectService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class ProjectTest @Autowired constructor(
    val projectService: ProjectService
) {

    @Test
    fun getProjectTest() {
        val project: ProjectDto? = projectService.getProject(UUID.fromString("018d5642-cc1b-f38b-a4ea-bfb39cfbb7d8"))
        println(project)
    }

    @Test
    fun getProjectWithHostTest() {
        val project: ProjectDto? =
            projectService.getProjectWithHost(UUID.fromString("018d5642-cc1b-f38b-a4ea-bfb39cfbb7d8"))
        println(project)
    }

    @Test
    fun getProjectsTest() {
        val projects = projectService.getProjects()
        println(projects)
    }

    @Test
    fun insertProjectTest() {
        val projectDto = ProjectDto(
            "from dto",
            listOf(
                ProjectEnvDto("dev", "dev.d2e.life"),
                ProjectEnvDto("qa", "qa.d2e.life"),
                ProjectEnvDto("live", "d2e.life")
            ),
        )
        val result = projectService.insertProject(projectDto)
        println(result)
    }

    @Test
    fun updateProjectTest() {
        val projectDto = ProjectDto(
            "from dto changed!",
            listOf(
                ProjectEnvDto("dev", "dev.d2e.life"),
                ProjectEnvDto("qa", "qa.d2e.life"),
                ProjectEnvDto("live", "d2e.life")
            ),
        )
        val result = projectService.updateProject(UUID.fromString("018d58cc-b491-eace-a801-1d43b0af1547"), projectDto)
        println(result)
    }

}
