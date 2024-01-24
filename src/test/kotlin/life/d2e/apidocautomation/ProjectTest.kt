package life.d2e.apidocautomation

import life.d2e.apidocautomation.domain.ProjectDomain
import life.d2e.apidocautomation.repository.ProjectRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProjectTest @Autowired constructor(
    val projectRepository: ProjectRepository
) {

    @Test
    fun insertProjectTest() {
        for (i: Int in 1..100) {
            var project = ProjectDomain("hello$i")
            projectRepository.save(project)
        }
    }

    @Test
    fun getProjectTest() {
        for (project in projectRepository.findAll()) {
            println("${project.id} ${project.projectName}")}
    }
}