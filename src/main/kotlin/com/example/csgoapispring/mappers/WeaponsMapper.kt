package com.example.csgoapispring.mappers

import com.example.csgoapispring.dto.WeaponsDTO
import com.example.csgoapispring.dto.WeaponsDTOSave
import com.example.csgoapispring.models.Players
import com.example.csgoapispring.models.Weapons


fun Weapons.toDto(): WeaponsDTO{
    return WeaponsDTO(
        id = this.id!!,
        weapontype = this.weapontype,
        scope=this.scope.toString(),
        magazines=this.magazines,
        players = players!!.username

    )
}

fun WeaponsDTOSave.toEntity(player: Players): Weapons{
    return Weapons(
        weapontype = this.weapontype,
        scope = this.scope.toBoolean(),
        magazines = this.magazines,
        players = player
    )
}