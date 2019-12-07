package ru.hokan.looker.sources.providers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.hokan.looker.sources.providers.database.dto.Source
import ru.hokan.looker.sources.providers.database.dto.SourceProvider
import ru.hokan.looker.sources.providers.database.dto.SourceProviderType
import ru.hokan.looker.sources.providers.database.repositories.SourcesProviderRepository
import ru.hokan.looker.sources.sources.sites.SiteSource

@Service
class SiteSourcesProviderImpl(@Autowired var siteSources : List<SiteSource>,
                              @Autowired var sourcesProviderRepository: SourcesProviderRepository) : SourcesProvider {

    override fun register() {
        val sourceProvider = SourceProvider(0, SourceProviderType.SITE_COLLECTION, SITE_SOURCES_PROVIDER_NAME, "")
        sourcesProviderRepository.save(sourceProvider)
    }

    override fun getSources(): List<Source> {
        return siteSources.map { it.getSource() }.onEach { it.sourceProviderId = 20 }
    }

    companion object {
        const val SITE_SOURCES_PROVIDER_NAME = "SiteSourcesProviderImpl"
    }
}