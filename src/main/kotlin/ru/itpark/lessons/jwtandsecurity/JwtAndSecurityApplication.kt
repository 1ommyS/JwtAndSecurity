package ru.itpark.lessons.jwtandsecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import ru.itpark.lessons.jwtandsecurity.config.SecurityConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties(value = [
    SecurityConfigurationProperties::class
])
class JwtAndSecurityApplication

fun main(args: Array<String>) {
    runApplication<JwtAndSecurityApplication>(*args)
}
