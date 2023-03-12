package com.example.csgoapispring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CsgoApiSpringApplication/*CommandLineRunner{
    @Autowired
    lateinit var repoPlayer:PlayersRepository
    @Autowired
    lateinit var repoWeapon:WeaponsRepository
    override fun run(vararg args: String?) {






    }

}*/

fun main(args: Array<String>) {
    runApplication<CsgoApiSpringApplication>(*args)
}
