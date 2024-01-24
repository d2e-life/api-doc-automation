package life.d2e.apidocautomation.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DocController {

    @GetMapping("/v1/ok")
    fun ok(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/v1/internal-sever-error")
    fun internalServerError(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @GetMapping("/v1/service-unavailable")
    fun serviceUnavailable(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE)
    }
}