package ru.hokan.looker.sources.suppliers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.hokan.looker.sources.providers.SourcesProvider
import ru.hokan.looker.sources.providers.database.repositories.SourcesRepository

@Service
class SourcesSupplierImpl(@Autowired var sourcesProviders: List<SourcesProvider>) : SourcesSupplier {

    @Autowired
    lateinit var sourcesRepository: SourcesRepository

    init {
        sourcesProviders.forEach { it.register() }
    }

    override fun updateSourcesList() {
        sourcesRepository.saveAll(sourcesProviders.flatMap { it.getSources() })
    }
}