package com.example.csgoapispring.repositories

import com.example.csgoapispring.models.Players
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayersRepository :JpaRepository<Players,Long>{
    fun findByUsername(username:String):Players?
}