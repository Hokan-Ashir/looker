package ru.hokan.looker.sources.sources.sites

import ru.hokan.looker.sources.providers.database.dto.Source

interface SiteSource {
    fun getSource() : Source
}