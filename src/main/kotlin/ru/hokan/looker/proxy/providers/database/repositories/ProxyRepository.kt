package ru.hokan.looker.proxy.providers.database.repositories

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hokan.looker.proxy.providers.database.dto.Proxy


@Repository
interface ProxyRepository : CrudRepository<Proxy, Int> {
    fun findAll(pageable: Pageable): Page<Proxy>
}