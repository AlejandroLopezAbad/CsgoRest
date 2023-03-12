package com.example.csgoapispring.dto


data class PlayersDTOLogin(
    val username: String,
    val password: String
)

data class PlayersDTO(
    val username: String,
    val rol: Set<String>,
    val weapons: List<WeaponsDTO>
)


data class PlayersWithTokenDto(
    val piloto: PlayersDTO,
    val token: String
)