package life.d2e.apidocautomation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class ApiDocAutomationApplication

fun main(args: Array<String>) {
    runApplication<ApiDocAutomationApplication>(*args)
}
