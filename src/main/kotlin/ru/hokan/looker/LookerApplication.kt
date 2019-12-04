package ru.hokan.looker

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.hokan.looker.sniffer.flow.Flow

@SpringBootApplication
class LookerApplication : ApplicationRunner {
    @Autowired
    lateinit var flow: Flow

    override fun run(args: ApplicationArguments?) {
        flow.executeFlow()
    }
}

fun main(args: Array<String>) {
    runApplication<LookerApplication>(*args)
}
