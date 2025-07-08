package ru.itpark.lessons.jwtandsecurity.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class User(
    val id: Long,
    private val login: String,
    private val password: String,
    private val roles: List<String>,
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = roles.map { SimpleGrantedAuthority(it) }.toMutableSet()

    override fun getPassword(): String = password

    override fun getUsername(): String = id.toString()
}
