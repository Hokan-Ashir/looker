package ru.hokan.looker.proxy.providers

import io.kotlintest.extensions.TestListener
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.spring.SpringListener
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.hokan.looker.LookerApplication

@SpringBootTest(classes = [LookerApplication::class])
class HideMyNameProxyProviderTest : StringSpec() {

    @Autowired
    lateinit var proxyProvider: HideMyNameFileProxyProvider

    @Before
    fun setUp() {
        proxyProvider.register()
    }

    override fun listeners(): List<TestListener> {
        return listOf(SpringListener)
    }

    init {

        "should extract proxies from file-like proxy provider" {
            val proxyList = proxyProvider.getProxyList()
            val expectedProxiesList = listOf("34.34.11.23", "45.66.77.123", "123.142.181.11")
            val proxyIPList = proxyList.map { it.IP }
            proxyIPList shouldBe expectedProxiesList
        }
    }
}