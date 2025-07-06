package ru.itpark.lessons.jwtandsecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JwtAndSecurityApplication

fun main(args: Array<String>) {
    runApplication<JwtAndSecurityApplication>(*args)
}
