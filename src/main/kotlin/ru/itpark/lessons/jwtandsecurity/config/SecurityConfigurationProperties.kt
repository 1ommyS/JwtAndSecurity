package ru.itpark.lessons.jwtandsecurity.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("security")
data class SecutityConfigurationProperties(
    var key: String,
    var ttl: Long
)
