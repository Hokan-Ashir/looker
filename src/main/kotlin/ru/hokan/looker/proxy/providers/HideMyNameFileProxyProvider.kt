package ru.hokan.looker.proxy.providers

import org.springframework.stereotype.Service

@Service
class HideMyNameFileProxyProvider : AbstractFileProxyProvider() {
    override fun getProxyProviderName(): String {
        return "hide.my.name"
    }
}