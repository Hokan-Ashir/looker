package ru.hokan.looker.proxy.providers

import io.kotlintest.shouldBe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import ru.hokan.looker.LookerApplication

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [LookerApplication::class])
class HideMyNameProxyProviderTest {

    @Autowired
    lateinit var proxyProvider: HideMyNameFileProxyProvider

    @Before
    fun setUp() {
        proxyProvider.register()
    }

    @Test
    fun `should extract proxies from file-like proxy provider`() {
        val proxyList = proxyProvider.getProxyList()
        val expectedProxiesList = listOf("34.34.11.23", "45.66.77.123", "123.142.181.11")
        val proxyIPList = proxyList.map { it.IP }
        proxyIPList shouldBe expectedProxiesList
    }
}