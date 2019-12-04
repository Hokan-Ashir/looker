package ru.hokan.looker.sources.sources

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("openNet")
class TlgurSource : Source {
    override fun getBaseURL(): String {
        return "https://tlgur.com/d/"
    }

    override fun getGeneratedURL(): String {
        return getBaseURL() + GeneratedURLUtils.getRandomString(
                RANDOMIZED_STRING_PART_LENGTH,
                GeneratedURLUtils.GENERATED_STRING_ELEMENTS.UPPERCASE,
                GeneratedURLUtils.GENERATED_STRING_ELEMENTS.LOWERCASE,
                GeneratedURLUtils.GENERATED_STRING_ELEMENTS.DIGITS
        )
    }

    companion object {
        const val RANDOMIZED_STRING_PART_LENGTH = 8
    }
}