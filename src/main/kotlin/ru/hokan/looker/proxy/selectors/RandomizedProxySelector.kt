package ru.hokan.looker.proxy.selectors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.hokan.looker.proxy.providers.database.repositories.ProxyRepository
import java.lang.Long.min
import kotlin.random.Random


@Service
class RandomizedProxySelector(@Autowired val proxyRepository: ProxyRepository) : ProxyProvidersSelector {

    override fun getProxySource(): String {
        val totalProxiesCount = proxyRepository.count()
        // TODO check this formulae
        val randomProxyTableIndex = min(totalProxiesCount, Random(0).nextInt() * totalProxiesCount)
        val proxiesPage = proxyRepository.findAll(PageRequest.of(randomProxyTableIndex.toInt(), 1))
        return proxiesPage.get().findAny().get().IP
    }
}