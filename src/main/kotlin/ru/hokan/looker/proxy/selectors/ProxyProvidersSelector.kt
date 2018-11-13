package ru.hokan.looker.proxy.selectors

interface ProxyProvidersSelector {
    fun getProxySource() : String
}