package ru.hokan.looker.proxy.providers.database.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hokan.looker.proxy.providers.database.dto.ProxyProvider

@Repository
interface ProxyProviderRepository : CrudRepository<ProxyProvider, Int> {
    fun findByName(name: String) : ProxyProvider
}