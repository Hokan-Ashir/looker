package ru.hokan.looker.sniffer.strategies

import org.springframework.stereotype.Component
import ru.hokan.looker.entities.ContentEntity

@Component
class TypicalUserStrategy : SniffingStrategy {
    override fun sniffSource(source: String, proxy : String): List<ContentEntity> {
        Thread.sleep((TYPICAL_USER_SITE_OPENING_TIMEOUT_SECONDS * 1000).toLong())
        println()
        return listOf()
    }

    companion object {
        const val TYPICAL_USER_SITE_OPENING_TIMEOUT_SECONDS = 4
    }

}