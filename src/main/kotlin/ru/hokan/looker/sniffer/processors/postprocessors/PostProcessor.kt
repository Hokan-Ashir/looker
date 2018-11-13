package ru.hokan.looker.sniffer.processors.postprocessors

import ru.hokan.looker.entities.ImageEntity

interface PostProcessor {
    fun processImages(imageEntities : List<ImageEntity>) : List<ImageEntity>
}