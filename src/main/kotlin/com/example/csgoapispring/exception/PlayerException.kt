package com.example.csgoapispring.exception


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

sealed class PlayerException(mensaje: String): RuntimeException(mensaje)

@ResponseStatus(HttpStatus.NOT_FOUND)
class PlayerNotFoundException(mensaje: String): RuntimeException(mensaje)
