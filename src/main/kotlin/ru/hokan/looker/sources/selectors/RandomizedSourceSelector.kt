package ru.hokan.looker.sources.selectors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.hokan.looker.sources.providers.SourcesProvider

@Service
class RandomizedSourceSelector(@Autowired val sourcesProviders : List<SourcesProvider>) : SourceSelector {
    override fun getSource(): String {
        return sourcesProviders.random().getSources().random().getGeneratedURL()
    }
}