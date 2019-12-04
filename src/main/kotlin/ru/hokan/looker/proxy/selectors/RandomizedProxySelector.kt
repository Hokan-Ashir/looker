package ru.hokan.looker.proxy.selectors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.hokan.looker.proxy.providers.ProxyProvider

@Service
class RandomizedProxySelector(@Autowired val proxyProviders : List<ProxyProvider>) : ProxyProvidersSelector {

    override fun getProxySource(): String {
        return proxyProviders.random().getProxies().random()
    }
}