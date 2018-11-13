package ru.hokan.looker.sniffer.processors.preprocessors.images.extractors

import ru.hokan.looker.entities.ContentEntity
import ru.hokan.looker.entities.ImageEntity
import ru.hokan.looker.sniffer.processors.preprocessors.PreProcessor

interface ImageExtractor : PreProcessor {
    override fun processEntities(contentEntities: List<ContentEntity>): List<ImageEntity> {
        return contentEntities.map { e -> extractImage(e) }.toCollection(ArrayList())
    }

    fun extractImage(contentEntity: ContentEntity) : ImageEntity
}