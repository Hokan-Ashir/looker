package ru.hokan.looker.proxy.providers

import java.io.File

abstract class AbstractProxyProvider : ProxyProvider {

    var proxyList : List<String> = mutableListOf()

    init {
        proxyList = extractProxyList();
    }

    final override fun extractProxyList(): List<String> {
        val proxyProviderFileListFullName = PROXY_PROVIDER_FILE_LIST_PREFIX + getProxyProviderName() + PROXY_PROVIDER_NAME_LIST_FILE_EXTENSION
        val proxyList = this.javaClass.classLoader.getResource(proxyProviderFileListFullName)
        return File(proxyList!!.file).readLines()
    }

    override fun getProxies(): List<String> {
        return proxyList
    }

    companion object {
        const val PROXY_PROVIDER_NAME_LIST_FILE_EXTENSION = ".txt"
        const val PROXY_PROVIDER_FILE_LIST_PREFIX = "pp_"
    }
}
