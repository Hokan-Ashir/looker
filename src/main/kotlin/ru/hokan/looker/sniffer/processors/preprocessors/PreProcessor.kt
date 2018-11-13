package ru.hokan.looker.sniffer.processors.preprocessors

import ru.hokan.looker.entities.ContentEntity
import ru.hokan.looker.entities.ImageEntity

interface PreProcessor {
    fun processEntities(contentEntities : List<ContentEntity>) : List<ImageEntity>
}