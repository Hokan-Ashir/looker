package ru.hokan.looker.sources.providers

import ru.hokan.looker.sources.providers.database.dto.Source

interface SourcesProvider {
    fun register()
    fun getSources() : List<Source>
}