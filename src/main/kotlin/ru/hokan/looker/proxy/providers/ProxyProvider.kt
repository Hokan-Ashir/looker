package ru.hokan.looker.proxy.providers

interface ProxyProvider {
    fun getProxies() : List<String>
    fun getProxyProviderName() : String
    fun extractProxyList() : List<String>
}