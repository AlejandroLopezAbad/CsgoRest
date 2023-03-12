package com.example.csgoapispring.services

import com.example.csgoapispring.dto.PlayersDTO
import com.example.csgoapispring.exception.PlayerNotFoundException
import com.example.csgoapispring.models.Players
import com.example.csgoapispring.repositories.PlayersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class PlayersService
@Autowired constructor(val playersRepo: PlayersRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return playersRepo.findByUsername(username)
            ?: throw PlayerNotFoundException("Player no encontrado con username $username")
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun loadPlayerbyId(playerId:String): Players?{
        return playersRepo.findById(playerId.toLong()).getOrNull()

    }

    fun findAll():List<Players>{
        return playersRepo.findAll()
    }


}