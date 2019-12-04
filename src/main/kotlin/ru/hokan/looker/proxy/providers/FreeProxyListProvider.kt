package ru.hokan.looker.proxy.providers

import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.impl.client.HttpClients
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import javax.xml.parsers.DocumentBuilderFactory


@Service
class FreeProxyListProvider : ProxyProvider {

    override fun getProxies(): List<String> {
        return extractProxyList()
    }

    override fun getProxyProviderName(): String {
        return "free-proxy-list"
    }

    override fun extractProxyList(): List<String> {
        val httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier()).build()

        val requestFactory = HttpComponentsClientHttpRequestFactory()
        val xmlResult = RestTemplate(requestFactory).getForObject(FREE_PROXY_LIST_URL, String::class.java)
        extractProxyIPsFromXML(xmlResult!!)
        return listOf()
    }

    fun extractProxyIPsFromXML(xml : String) {
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val doc = builder.parse(xml)
        val elementsByTagName = doc.getElementsByTagName(TR_TAG_NAME)
        val ips = (0..elementsByTagName.length).map { elementsByTagName.item(it).firstChild.nodeValue }
        println()
    }

    companion object {
        const val FREE_PROXY_LIST_URL = "https://free-proxy-list.net/"
        const val TR_TAG_NAME = "tr"
    }
}