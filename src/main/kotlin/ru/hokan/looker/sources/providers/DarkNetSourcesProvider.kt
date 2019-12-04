package ru.hokan.looker.sources.providers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import ru.hokan.looker.sources.sources.Source

@Service
class DarkNetSourcesProvider(@Qualifier("darkNet") @Autowired val sourceList: List<Source>) : SourcesProvider {
    override fun getSources(): List<Source> {
        return sourceList
    }
}