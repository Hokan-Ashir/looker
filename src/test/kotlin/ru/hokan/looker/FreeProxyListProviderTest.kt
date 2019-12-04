package ru.hokan.looker

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import ru.hokan.looker.proxy.providers.FreeProxyListProvider

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [FreeProxyListProvider::class])
class FreeProxyListProviderTest {

    @Autowired
    lateinit var freeProxyListProvider: FreeProxyListProvider

    @Test
    fun `should run flow with name against source list with proxy`() {
        freeProxyListProvider.getProxies()
    }

    companion object {
        const val EXECUTE_FLOW_WITH_NAME_ENDPOINT = "/executeFlow"
    }
}
