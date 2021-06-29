package com.luanss.gamist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class MainApplication

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}

@RestController
class AppController {
    @GetMapping
    fun health(): Message {
        return Message("Systems up")
    }
}

data class Message(val text: String)