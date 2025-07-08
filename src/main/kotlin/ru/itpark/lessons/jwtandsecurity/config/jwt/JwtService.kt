package ru.itpark.lessons.jwtandsecurity.config.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import ru.itpark.lessons.jwtandsecurity.config.SecurityConfigurationProperties
import ru.itpark.lessons.jwtandsecurity.entity.User
import java.time.Instant
import java.util.*

@Service
class JwtService(
    properties: SecurityConfigurationProperties,
) {
    @PostConstruct
    fun postConstruct() {
        println(key)
        println(ttl)
    }

    val key = Keys.hmacShaKeyFor(properties.key.encodeToByteArray())
    val ttl = properties.ttl

    fun generateToken(user: User): String =
        Jwts
            .builder()
            .subject(user.username)
            .claims(
                mapOf(
                    "password" to user.password,
                ),
            ).issuedAt(Date())
            .expiration(Date.from(Instant.now().plusSeconds(ttl)))
            .signWith(key)
            .compact()

    private fun isTokenExpired(token: String) = claims(token).expiration.before(Date())

    fun subject(token: String): String = claims(token).subject

    private fun parseWithKey(token: String): Claims =
        Jwts
            .parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .payload

    private fun claims(token: String): Claims = parseWithKey(token)

    fun isTokenValid(
        token: String,
        userDetails: User?,
    ): Boolean {
        val subject = subject(token)

        return subject == userDetails?.username && !isTokenExpired(token)
    }
}
