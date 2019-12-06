package ru.hokan.looker.sources.providers.database.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hokan.looker.sources.providers.database.dto.SourceProvider

@Repository
interface SourcesProviderRepository : CrudRepository<SourceProvider, Int> {
}