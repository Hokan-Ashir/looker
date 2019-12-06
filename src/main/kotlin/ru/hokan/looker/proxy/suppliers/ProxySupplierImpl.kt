package ru.hokan.looker.proxy.suppliers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.hokan.looker.proxy.providers.ProxyProvider
import ru.hokan.looker.proxy.providers.database.repositories.ProxyRepository

@Service
class ProxySupplierImpl(@Autowired val proxyProviders: List<ProxyProvider>,
                        @Autowired val proxyRepository: ProxyRepository) : ProxySupplier {
    init {
        proxyProviders.forEach { it.register() }
    }

    override fun updateProxyList() {
        // TODO check that this will update proxies list
        proxyRepository.saveAll(proxyProviders.flatMap { it.getProxyList() })
    }
}