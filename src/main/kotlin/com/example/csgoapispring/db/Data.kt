package com.example.csgoapispring.db

import com.example.csgoapispring.models.Players
import com.example.csgoapispring.models.Weapons




    fun getPlayers(): List<Players> {
        return mutableListOf(
            Players(
                username = "alexitto",
                password = "$2a$12$4ZqHz8Eoqoswgs2yVjqAue/oHuHvOzL/FHUaGfapJAq.Z4qMfvPSy",
                name = "Alejandro",
                rol = "CHEATER",
                weapons = mutableListOf()
            ),
            Players(
                username = "Xcard",
                password = "\$2a\$12\$4ZqHz8Eoqoswgs2yVjqAue/oHuHvOzL/FHUaGfapJAq.Z4qMfvPSy",
                name = "Carta",
                rol = "LEGITPLAYER",
                weapons = mutableListOf()
            ),
            Players(
                username = "Ekixx",
                password = "ekixx1234",
                name = "Adri",
                rol = "LEGITPLAYER",
                weapons = mutableListOf()
            ),
        )
    }


    fun getWeapons(): List<Weapons> {
        return mutableListOf(
            Weapons(
                weapontype = "CT",
                scope = true,
                magazines = 4,
                players = Players(
                    id = 1,
                    username = "Alexitto",
                    password = "alexitto1234",
                    name = "Alexitto",
                    weapons = mutableListOf(),
                )
            ),
            Weapons(
                weapontype = "TERROR",
                scope = true,
                magazines = 3,
                players = Players(
                    id = 2,
                    username = "Xcard",
                    password = "xcard1234",
                    name = "Carta",
                    weapons = mutableListOf(),
                )
            ),
            Weapons(
                weapontype = "TERROR",
                scope = false,
                magazines = 5,
                players = Players(
                    id = 1,
                    username = "Alexitto",
                    password = "alexitto1234",
                    name = "Alexitto",
                    weapons = mutableListOf(),
                )
            )
        )

    }
