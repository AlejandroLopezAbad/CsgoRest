package com.example.csgoapispring.dto


data class WeaponsDTOSave(
    val weapontype: String,
    val scope: String,
    val magazines: Int,
    val players: String
)

data class WeaponsDTO(
    val id: Long,
    val weapontype: String,
    val scope: String,
    val magazines: Int,
    val players: String
)