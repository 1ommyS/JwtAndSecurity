package ru.itpark.lessons.jwtandsecurity

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/private")
class DemoController {
    @GetMapping("hello")
    fun hello() = "Hello World!"
}

