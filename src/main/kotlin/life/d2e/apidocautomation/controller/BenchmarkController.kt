package life.d2e.apidocautomation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BenchmarkController {


    @GetMapping("/demo/dashboard-benchmark")
    fun dashboardDemoPage(): String {
        return "pages/dashboards/index-benchmark"
    }

}
