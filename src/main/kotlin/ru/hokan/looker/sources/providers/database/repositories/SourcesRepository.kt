package ru.hokan.looker.sources.providers.database.repositories

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hokan.looker.sources.providers.database.dto.Source

@Repository
interface SourcesRepository : CrudRepository<Source, Int> {
    fun findAll(pageable: Pageable): Page<Source>
}