package com.example.csgoapispring.repositories

import com.example.csgoapispring.models.Players
import com.example.csgoapispring.models.Weapons
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WeaponsRepository :JpaRepository<Weapons,Long>{
    suspend fun findByPlayersUsername(players_username: String):List<Weapons>
}