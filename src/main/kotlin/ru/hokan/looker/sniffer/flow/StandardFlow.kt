package ru.hokan.looker.sniffer.flow

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ru.hokan.looker.proxy.selectors.ProxyProvidersSelector
import ru.hokan.looker.sniffer.processors.postprocessors.PostProcessor
import ru.hokan.looker.sniffer.processors.preprocessors.PreProcessor
import ru.hokan.looker.sniffer.strategies.SniffingStrategy
import ru.hokan.looker.sources.selectors.SourceSelector
import ru.hokan.looker.storage.Saver
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Service
class StandardFlow(@Autowired val sniffingStrategy: SniffingStrategy,
                   @Autowired val proxyProvidersSelector: ProxyProvidersSelector,
                   @Autowired val sourcesSelector: SourceSelector,
                   @Autowired val preProcessors : List<PreProcessor>,
                   @Autowired val postProcessors : List<PostProcessor>,
                   @Autowired val savers : List<Saver>) : Flow {
    @Value("\${looker.number.of.sources.to.try}")
    var numberOfSourcesToTry : Int? = null

    @Value("\${looker.number.of.threads}")
    var numberOfThreads : Int? = null

    override fun executeFlow() {
        val executorService = Executors.newFixedThreadPool(numberOfThreads!!)
        val executions = (1..numberOfThreads!!).map {
            Callable {
                for (i in 1..numberOfSourcesToTry!!) {
                    val proxySource = proxyProvidersSelector.getProxySource()
                    val source = sourcesSelector.getSource()
                    val contentEntities = sniffingStrategy.sniffSource(source, proxySource)
                    val imageEntities = preProcessors.flatMap { e -> e.processEntities(contentEntities) }.toCollection(ArrayList())
                    val processedImageEntities = postProcessors.flatMap { e -> e.processImages(imageEntities) }.toCollection(ArrayList())
                    savers.forEach { e -> e.storeImageEntities(processedImageEntities) }
                }
            }
        }.toCollection(ArrayList())
        executorService.invokeAll(executions)
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS)
    }

    override fun getFlowName(): String {
        return STANDARD_FLOW_NAME
    }

    companion object {
        const val STANDARD_FLOW_NAME = "standard"
    }
}