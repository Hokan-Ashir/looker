package ru.hokan.looker.storage

import ru.hokan.looker.entities.ImageEntity

interface Saver {
    fun storeImageEntities(imageEntities : List<ImageEntity>)
}