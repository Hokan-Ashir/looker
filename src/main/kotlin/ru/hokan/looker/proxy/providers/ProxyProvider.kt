package ru.hokan.looker.proxy.providers

import ru.hokan.looker.proxy.providers.database.dto.Proxy

interface ProxyProvider {
    fun register()
    fun getProxyList() : List<Proxy>
}