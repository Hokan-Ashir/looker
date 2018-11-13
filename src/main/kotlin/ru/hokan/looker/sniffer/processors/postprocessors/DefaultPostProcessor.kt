package ru.hokan.looker.sniffer.processors.postprocessors

import org.springframework.stereotype.Component
import ru.hokan.looker.entities.ImageEntity

@Component
class DefaultPostProcessor : PostProcessor {
    override fun processImages(imageEntities: List<ImageEntity>): List<ImageEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}