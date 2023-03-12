package com.example.csgoapispring.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.Min
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "players")
  data class Players(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @get:JvmName("username")
    val username: String,
    @Min(5)
    @get:JvmName("password")
    val password: String,
    val name: String? = "",
    val rol: String = Rol.LEGITPLAYER.name,
    @OneToMany
    val weapons: MutableList<Weapons>

):UserDetails {




    enum class Rol {

        CHEATER, LEGITPLAYER
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return rol.split(",").map { SimpleGrantedAuthority("ROLE_${it.trim()}") }.toMutableList()
    }

    override fun getPassword(): String {
   return password
    }

    override fun getUsername(): String {
      return username
    }

    override fun isAccountNonExpired(): Boolean {
     return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

