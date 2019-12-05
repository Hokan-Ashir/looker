package ru.hokan.looker.proxy.providers

import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.impl.client.HttpClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.hokan.looker.proxy.providers.database.dto.Proxy
import ru.hokan.looker.proxy.providers.database.dto.ProxyProviderType
import ru.hokan.looker.proxy.providers.database.repositories.ProxyProviderRepository
import java.sql.Timestamp
import java.time.Instant
import javax.xml.parsers.DocumentBuilderFactory


@Service
class FreeProxyListProvider : ProxyProvider {

    @Autowired
    lateinit var proxyProviderRepository: ProxyProviderRepository

    override fun register() {
        val proxyProviderDTO = ru.hokan.looker.proxy.providers.database.dto.ProxyProvider(0, ProxyProviderType.SITE, FREE_PROXY_LIST_URL, FREE_PROXY_LIST_PROVIDER_NAME)
        proxyProviderRepository.save(proxyProviderDTO)
    }

    override fun getProxyList(): List<Proxy> {
        val proxyProvider = proxyProviderRepository.findByName(FREE_PROXY_LIST_PROVIDER_NAME)
        return extractProxyList().map { Proxy(0, it, proxyProvider.id, Timestamp.from(Instant.now())) }
    }

    fun extractProxyList(): List<String> {
        val httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier()).build()

        val requestFactory = HttpComponentsClientHttpRequestFactory()
        val xmlResult = RestTemplate(requestFactory).getForObject(FREE_PROXY_LIST_URL, String::class.java)
        extractProxyIPsFromXML(xmlResult!!)
        return listOf()
    }

    fun extractProxyIPsFromXML(xml: String) {
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val doc = builder.parse(xml)
        val elementsByTagName = doc.getElementsByTagName(TR_TAG_NAME)
        val ips = (0..elementsByTagName.length).map { elementsByTagName.item(it).firstChild.nodeValue }
        println()
    }

    companion object {
        const val FREE_PROXY_LIST_PROVIDER_NAME = "free-proxy-list"
        const val FREE_PROXY_LIST_URL = "https://free-proxy-list.net/"
        const val TR_TAG_NAME = "tr"
    }
}