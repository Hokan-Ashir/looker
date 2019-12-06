package ru.hokan.looker.proxy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import ru.hokan.looker.proxy.suppliers.ProxySupplier
import java.time.Duration

@Configuration
class ProxyConfiguration {

    @Value("\${looker.updating.proxy.list.interval.minutes}")
    var updatingProxyListIntervalMinutes: Long = DEFAULT_UPDATING_PROXY_LIST_INTERVAL_MIN

    @Autowired
    lateinit var proxySupplier: ProxySupplier

    @Bean
    fun proxiesThreadPoolTaskScheduler(): ThreadPoolTaskScheduler {
        val taskScheduler = ThreadPoolTaskScheduler()
        taskScheduler.poolSize = 10
        taskScheduler.initialize()
        taskScheduler.scheduleWithFixedDelay(proxySupplier::updateProxyList, Duration.ofMinutes(updatingProxyListIntervalMinutes))
        return taskScheduler
    }

    companion object {
        const val DEFAULT_UPDATING_PROXY_LIST_INTERVAL_MIN = 10L
    }
}