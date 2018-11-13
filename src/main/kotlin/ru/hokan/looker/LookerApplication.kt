package ru.hokan.looker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LookerApplication

fun main(args: Array<String>) {
    runApplication<LookerApplication>(*args)
}
