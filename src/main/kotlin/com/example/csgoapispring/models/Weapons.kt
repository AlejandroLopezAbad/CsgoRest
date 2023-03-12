package com.example.csgoapispring.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

@Entity
data class Weapons(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id :Long?= null,
    val weapontype:String=WeaponType.CT.name,
    val scope:Boolean,
    @Min(2)
    @Max(6)
    val magazines:Int,
    @OneToOne
    val players:Players?
) {
    enum class WeaponType{
        CT,TERROR

    }
}