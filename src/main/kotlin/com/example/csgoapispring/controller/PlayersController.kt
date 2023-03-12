package com.example.csgoapispring.controller

import com.example.csgoapispring.config.jwt.JwtTokenUtils

import com.example.csgoapispring.dto.PlayersDTO
import com.example.csgoapispring.dto.PlayersDTOLogin
import com.example.csgoapispring.dto.PlayersWithTokenDto
import com.example.csgoapispring.mappers.toDto

import com.example.csgoapispring.mappers.toDtoV
import com.example.csgoapispring.models.Players

import com.example.csgoapispring.services.PlayersService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/players")
class PlayersController
@Autowired constructor (private val playersService: PlayersService,
                        private val authenticationManager: AuthenticationManager,
                        private val jwtTokenUtil: JwtTokenUtils,

) {


        @PostMapping("/login")
        fun login( @RequestBody logingDto: PlayersDTOLogin): ResponseEntity<PlayersWithTokenDto> {
            println(logingDto)
            val authentication: Authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    logingDto.username,
                    logingDto.password
                )
            )
                println(logingDto)


            SecurityContextHolder.getContext().authentication = authentication

            val user = authentication.principal as Players

            val jwtToken: String = jwtTokenUtil.generateToken(user)


            val userWithToken = PlayersWithTokenDto(user.toDto(), jwtToken)

            return ResponseEntity.ok(userWithToken)
        }

         @PreAuthorize("hasRole('CHEATER')")
        @GetMapping("/list")
        fun getAllPlayers(): ResponseEntity<List<PlayersDTO>> {
            val res = playersService.findAll().map { it.toDto() }
            return ResponseEntity.ok(res)
        }


    @GetMapping("/me")
    fun getMe(@AuthenticationPrincipal piloto: Players): ResponseEntity<PlayersDTO> {
        return ResponseEntity.ok(piloto.toDtoV())
    }

    }
