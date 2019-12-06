package ru.hokan.looker.sources.generators

import ru.hokan.looker.sources.providers.database.dto.Source

interface SourceGenerator {
    fun generateSourceURL(source : Source) : String
}