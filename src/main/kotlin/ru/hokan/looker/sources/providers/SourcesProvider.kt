package ru.hokan.looker.sources.providers

interface SourcesProvider {

    fun getSources() : List<String>
}