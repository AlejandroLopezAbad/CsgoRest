package com.example.csgoapispring.controller


import com.example.csgoapispring.db.getPlayers
import com.example.csgoapispring.db.getWeapons
import com.example.csgoapispring.dto.PlayersDTO
import com.example.csgoapispring.dto.WeaponsDTO
import com.example.csgoapispring.mappers.toDto
import com.example.csgoapispring.mappers.toDtoV
import com.example.csgoapispring.repositories.PlayersRepository
import com.example.csgoapispring.repositories.WeaponsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weapons")
class WeaponsController
@Autowired constructor(private val repo: WeaponsRepository,
private val repoPlayer:PlayersRepository){
/*
    init {
        getPlayers().forEach {
            repoPlayer.save(it)
        }
        getWeapons().forEach {
            repo.save(it)
        }

    }*/

    @GetMapping("/list")
    fun getAllWeapons(): ResponseEntity<List<WeaponsDTO>> {
        val res = repo.findAll().map { it.toDto() }
        return ResponseEntity.ok(res)
    }
}