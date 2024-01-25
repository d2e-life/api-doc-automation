package life.d2e.apidocautomation

import com.fasterxml.jackson.databind.ObjectMapper
import life.d2e.apidocautomation.domain.HostDomain
import life.d2e.apidocautomation.domain.ProjectDomain
import life.d2e.apidocautomation.repository.HostRepository
import life.d2e.apidocautomation.repository.ProjectRepository
import life.d2e.apidocautomation.service.ProjectService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProjectTest @Autowired constructor(
    val projectRepository: ProjectRepository,
    val hostRepository: HostRepository,
    val objectMapper: ObjectMapper,
    val projectService: ProjectService
) {

    @Test
    fun insertProjectTest() {
        for (i: Int in 1..100) {
            val project = ProjectDomain("hello$i")
            projectRepository.save(project)
        }
    }

    @Test
    fun getProjectTest() {
        for (project in projectService.getProjects()) {
            println("${project.id} ${project.projectName}")
        }
    }

    @Test
    fun insertProjectWithHost() {
        val project = ProjectDomain("test-project")
        projectRepository.save(project)

        hostRepository.saveAll(
            mutableListOf(
                HostDomain("local", "http://localhost:8080", project),
                HostDomain("dev", "https://dev-api.d2e.life", project),
                HostDomain("qa", "https://qa-api.d2e.life", project),
                HostDomain("live", "https://api.d2e.life", project),
            )
        )
    }

    @Test
    fun getProjectWithHost() {
        val projects: List<ProjectDomain> = projectRepository.findAll()
        println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(projects))
    }

}