package ru.hokan.looker.sources.selectors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.hokan.looker.sources.generators.SourceGenerator
import ru.hokan.looker.sources.providers.database.repositories.SourcesRepository
import java.lang.Long
import kotlin.random.Random

@Service
class RandomizedSourceSelector(@Autowired val sourceGenerator: SourceGenerator,
                               @Autowired val sourcesRepository: SourcesRepository) : SourceSelector {

    override fun getSource(): String {
        val totalSourcesCount = sourcesRepository.count()
        // TODO check this formulae
        val randomSourceTableIndex = Long.min(totalSourcesCount, Random(0).nextInt() * totalSourcesCount)
        val proxiesPage = sourcesRepository.findAll(PageRequest.of(randomSourceTableIndex.toInt(), 1))
        return sourceGenerator.generateSourceURL(proxiesPage.get().findFirst().get())
    }
}