package ru.hokan.looker.sources

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import ru.hokan.looker.sources.suppliers.SourcesSupplier
import java.time.Duration

@Configuration
class SourcesConfiguration {

    @Value("\${looker.updating.sources.list.interval.minutes}")
    var updatingSourcesListIntervalMinutes: Long = DEFAULT_UPDATING_SOURCES_LIST_INTERVAL_MIN

    @Autowired
    lateinit var sourcesSupplier: SourcesSupplier

    @Bean
    fun sourcesThreadPoolTaskScheduler(): ThreadPoolTaskScheduler {
        val taskScheduler = ThreadPoolTaskScheduler()
        taskScheduler.poolSize = 10
        taskScheduler.initialize()
        taskScheduler.scheduleWithFixedDelay(sourcesSupplier::updateSourcesList, Duration.ofMinutes(updatingSourcesListIntervalMinutes))
        return taskScheduler
    }

    companion object {
        const val DEFAULT_UPDATING_SOURCES_LIST_INTERVAL_MIN = 10L
    }
}