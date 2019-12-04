package ru.hokan.looker.sources.providers

import ru.hokan.looker.sources.sources.Source

interface SourcesProvider {

    fun getSources() : List<Source>
}