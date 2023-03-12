package com.example.csgoapispring.config.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.example.csgoapispring.exception.TokenException
import com.example.csgoapispring.models.Players
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenUtils {
    @Value("\${jwt.secret}")
    private val secret: String? = null
    @Value("\${jwt.token-expiration:3600}")
    private val duracion = 300

    fun generateToken(player: Players): String {
        val expiracion = Date(System.currentTimeMillis() * 1000 + duracion)
        return JWT.create()
            .withSubject(player.id.toString())
            .withHeader(mapOf("typ" to "JWT"))
            .withIssuedAt(Date())
            .withExpiresAt(expiracion)
            .withClaim("username", player.username)
            .withClaim("roles", player.rol.split(",").toSet().toString())
            .sign(Algorithm.HMAC512(secret))
    }
    fun validateToken(authToken: String): DecodedJWT? {
        try {
            return JWT.require(Algorithm.HMAC512(secret)).build().verify(authToken)
        } catch (e: Exception) {
            throw TokenException("Token no válido o expirado")
        }
    }
    fun isTokenValid(token: String): Boolean {
        val claims = validateToken(token)?.claims!!
        val expirationDate = claims["exp"]!!.asDate()
        val now = Date(System.currentTimeMillis())
        return now.before(expirationDate)
    }
}