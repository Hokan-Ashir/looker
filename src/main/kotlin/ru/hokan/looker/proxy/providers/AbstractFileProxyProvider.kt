package ru.hokan.looker.proxy.providers

import org.springframework.beans.factory.annotation.Autowired
import ru.hokan.looker.proxy.providers.database.dto.Proxy
import ru.hokan.looker.proxy.providers.database.dto.ProxyProviderType
import ru.hokan.looker.proxy.providers.database.repositories.ProxyProviderRepository
import java.io.File
import java.sql.Timestamp
import java.time.Instant

abstract class AbstractFileProxyProvider : ProxyProvider {

    @Autowired
    lateinit var proxyProviderRepository: ProxyProviderRepository

    override fun register() {
        val proxyProviderFileListFullName = PROXY_PROVIDER_FILE_LIST_PREFIX + getProxyProviderName() + PROXY_PROVIDER_NAME_LIST_FILE_EXTENSION
        val proxyListFileURL = this.javaClass.classLoader.getResource(proxyProviderFileListFullName)
        val proxyProviderDTO = ru.hokan.looker.proxy.providers.database.dto.ProxyProvider(0, ProxyProviderType.FILE, proxyListFileURL!!.path, getProxyProviderName())
        proxyProviderRepository.save(proxyProviderDTO)
    }

    override fun getProxyList(): List<Proxy> {
        val proxyProvider = proxyProviderRepository.findByName(getProxyProviderName())
        val sourceURL = proxyProvider.source
        return File(sourceURL).readLines().map { Proxy(0, it, proxyProvider.id, Timestamp.from(Instant.now())) }
    }

    protected abstract fun getProxyProviderName() : String

    companion object {
        const val PROXY_PROVIDER_NAME_LIST_FILE_EXTENSION = ".txt"
        const val PROXY_PROVIDER_FILE_LIST_PREFIX = "pp_"
    }
}
