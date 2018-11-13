package ru.hokan.looker.storage

import org.springframework.stereotype.Component
import ru.hokan.looker.entities.ImageEntity

@Component
class OnDiskImageSaver : Saver {
    override fun storeImageEntities(imageEntities: List<ImageEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}