package ru.hokan.looker.sources.sources.sites

import org.springframework.stereotype.Component
import ru.hokan.looker.sources.providers.database.dto.Source

@Component
class TlgurSource : SiteSource {

    companion object {
        const val TLGUR_BASE_URL = "https://tlgur.com/d/"
        const val RANDOMIZED_STRING_PART_LENGTH = 8
    }

    override fun getSource(): Source {
        return Source(0, TLGUR_BASE_URL, "[A-Za-z0-9]{1, $RANDOMIZED_STRING_PART_LENGTH}", 0)
    }
}