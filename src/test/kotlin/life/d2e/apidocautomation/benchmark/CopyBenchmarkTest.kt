package life.d2e.apidocautomation.benchmark

import life.d2e.apidocautomation.theme.DefaultDarkSidebar
import life.d2e.apidocautomation.theme.KTLayout
import life.d2e.apidocautomation.theme.KTLayoutWrapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CopyBenchmarkTest @Autowired constructor(
    val ktLayoutWrapper: KTLayoutWrapper
) {

    /**
     * 10000 -> 10 millis
     * 100000 -> 49 millis
     * 1000000 -> 219 millis
     */
    @Test
    fun copy() {
        val count = 1000000
        val start = System.currentTimeMillis()
        for (i in 0..count) {
            val defaultDarkSidebar = ktLayoutWrapper.get("defaultDarkSidebar")
            val pageLayout: KTLayout = (defaultDarkSidebar as DefaultDarkSidebar).copy()
        }
        val end = System.currentTimeMillis()
        println("$count 회 처리에 걸린 시간 = (${(end-start)})")
    }

    /**
     * 10000 -> 0 millis
     * 100000 -> 4 millis
     * 100000 -> 12 millis
     */
    @Test
    fun noCopy() {
        val count = 1000000
        val start = System.currentTimeMillis()
        for (i in 0..count) {
            val defaultDarkSidebar = ktLayoutWrapper.get("defaultDarkSidebar")
        }
        val end = System.currentTimeMillis()
        println("$count 회 처리에 걸린 시간 = (${(end-start)})")
    }
}
