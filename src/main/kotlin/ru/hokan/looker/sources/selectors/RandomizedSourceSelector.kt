package ru.hokan.looker.sources.selectors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.hokan.looker.sources.providers.SourcesProvider
import java.util.*

@Service
class RandomizedSourceSelector(@Autowired val sourcesProviders : List<SourcesProvider>) : SourceSelector {
    override fun getSource(): String {
        val random = Random()
        val nextSourcesProviderIndex = Math.abs(random.nextInt()) % sourcesProviders.size
        val sourcesProvider = sourcesProviders[nextSourcesProviderIndex]
        val sources = sourcesProvider.getSources()
        val nextSourceIndex = Math.abs(random.nextInt()) % sources.size
        return sources[nextSourceIndex]
    }
}