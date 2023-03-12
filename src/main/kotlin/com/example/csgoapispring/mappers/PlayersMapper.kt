package com.example.csgoapispring.mappers

import com.example.csgoapispring.dto.PlayersDTO
import com.example.csgoapispring.dto.PlayersDTOLogin
import com.example.csgoapispring.models.Players
import com.example.csgoapispring.models.Weapons

fun Players.toDto():PlayersDTO{
    return PlayersDTO(
        username = this.username,
        rol = rol.split(",").map { it.trim() }.toSet(),
        weapons = this.weapons.map { it.toDto() }
    )
}

fun PlayersDTOLogin.toEntity(armas: MutableList<Weapons>): Players{
    return Players(
        username = this.username,
        password = this.password,

        weapons = armas,

    )
}
fun Players.toDtoV(): PlayersDTO{
    return PlayersDTO(
        username = this.username,
        rol = rol.split(",").map { it.trim() }.toSet(),
        weapons = mutableListOf()
    )
}

