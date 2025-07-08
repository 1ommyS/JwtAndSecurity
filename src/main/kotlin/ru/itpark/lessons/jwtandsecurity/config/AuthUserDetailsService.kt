package ru.itpark.lessons.jwtandsecurity.config

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.itpark.lessons.jwtandsecurity.entity.User

@Service
class AuthUserDetailsService : UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails =
        User(id = id.toLong(), login = "d", password = "dd", roles = listOf("ADMIN"))

}
