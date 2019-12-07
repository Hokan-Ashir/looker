package ru.hokan.looker.sources.generators

import org.springframework.stereotype.Service
import ru.hokan.looker.sources.providers.database.dto.Source

@Service
class SourceGeneratorImpl : SourceGenerator {
    override fun generateSourceURL(source: Source): String {
        val regexp = source.regexp
        val generatedStringElements = mutableListOf<GeneratedURLUtils.GENERATED_STRING_ELEMENTS>()
        if (regexp.contains("A-Z")) {
            generatedStringElements.add(GeneratedURLUtils.GENERATED_STRING_ELEMENTS.UPPERCASE)
        }

        if (regexp.contains("a-z")) {
            generatedStringElements.add(GeneratedURLUtils.GENERATED_STRING_ELEMENTS.LOWERCASE)
        }

        if (regexp.contains("0-9")) {
            generatedStringElements.add(GeneratedURLUtils.GENERATED_STRING_ELEMENTS.DIGITS)
        }

        val randomURLLength = regexp.split("{}")[1].split(",")[1].toInt()
        return GeneratedURLUtils.getRandomString(randomURLLength, generatedStringElements)
    }
}