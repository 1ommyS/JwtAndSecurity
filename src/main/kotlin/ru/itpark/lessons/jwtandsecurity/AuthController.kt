package ru.itpark.lessons.jwtandsecurity

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.itpark.lessons.jwtandsecurity.config.jwt.JwtService
import ru.itpark.lessons.jwtandsecurity.entity.User
import java.util.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val jwtService: JwtService,
) {
    @PostMapping
    fun getToken(): String =
        jwtService.generateToken(
            User(
                id = 1,
                login = UUID.randomUUID().toString(),
                password = UUID.randomUUID().toString(),
                roles = listOf("ADMIN"),
            ),
        )
}
