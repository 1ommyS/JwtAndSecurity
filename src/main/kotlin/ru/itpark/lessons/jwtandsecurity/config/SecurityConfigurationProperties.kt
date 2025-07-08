package ru.itpark.lessons.jwtandsecurity.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("security")
data class SecurityConfigurationProperties(
    var key: String,
    var ttl: Long
)
