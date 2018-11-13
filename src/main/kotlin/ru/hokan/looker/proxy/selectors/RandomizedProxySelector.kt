package ru.hokan.looker.proxy.selectors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.hokan.looker.proxy.providers.ProxyProvider
import java.util.*

@Service
class RandomizedProxySelector(@Autowired val proxyProviders : List<ProxyProvider>) : ProxyProvidersSelector {

    override fun getProxySource(): String {
        val random = Random()
        val nextProxyProviderIndex = Math.abs(random.nextInt()) % proxyProviders.size
        val proxyProvider = proxyProviders[nextProxyProviderIndex]
        val proxies = proxyProvider.getProxies()
        val nextProxyIndex = Math.abs(random.nextInt()) % proxies.size
        return proxies[nextProxyIndex]
    }
}