package ru.hokan.looker.sniffer.processors.preprocessors.images.extractors

import org.springframework.stereotype.Component
import ru.hokan.looker.entities.ContentEntity
import ru.hokan.looker.entities.ImageEntity

@Component
class DefaultImageExtractor : ImageExtractor {
    override fun extractImage(contentEntity: ContentEntity): ImageEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}