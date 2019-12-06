package ru.hokan.looker.sources.generators

import org.springframework.stereotype.Service
import ru.hokan.looker.sources.providers.database.dto.Source

@Service
class SourceGeneratorImpl : SourceGenerator {
    override fun generateSourceURL(source: Source): String {
        val regexp = source.regexp

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}