package com.example.csgoapispring.config

import com.example.csgoapispring.config.jwt.JwtAuthenticationFilter
import com.example.csgoapispring.config.jwt.JwtAuthorizationFilter
import com.example.csgoapispring.config.jwt.JwtTokenUtils
import com.example.csgoapispring.services.PlayersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
class  SecurityConfig @Autowired constructor(
    private val servicePlayer: PlayersService,
    private val utilsJwt: JwtTokenUtils
) {

    @Bean
    fun authManager(http: HttpSecurity): AuthenticationManager {
        val authenticationManagerBuilder = http.getSharedObject(
            AuthenticationManagerBuilder::class.java
        )
        authenticationManagerBuilder.userDetailsService(servicePlayer)
        return authenticationManagerBuilder.build()
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        val authenticationManager = authManager(http)
        http
            .csrf().disable().exceptionHandling()
            .and().authenticationManager(authenticationManager)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeHttpRequests()
            .requestMatchers("/players/**").permitAll()
            .requestMatchers("/players/login").permitAll()
         //   .requestMatchers("/players/me").hasAnyRole("CHEATER", "LEGITPLAYER")
            .requestMatchers("/weapons/**").hasAnyRole("CHEATER", "LEGITPLAYER")
            //.requestMatchers( "/swagger-ui").permitAll()
            .anyRequest().authenticated().and()
            .addFilter(JwtAuthenticationFilter(utilsJwt, authenticationManager))
            .addFilter(JwtAuthorizationFilter(utilsJwt, servicePlayer, authenticationManager))
        return http.build()
    }
}