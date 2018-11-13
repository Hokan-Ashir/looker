package ru.hokan.looker.sniffer.strategies

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.hokan.looker.entities.ContentEntity
import ru.hokan.looker.sniffer.processors.preprocessors.PreProcessor

@Component
class TypicalUserStrategy : SniffingStrategy {
    override fun sniffSource(source: String, proxy : String): List<ContentEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}