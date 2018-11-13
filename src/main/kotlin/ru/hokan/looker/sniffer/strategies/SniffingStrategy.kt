package ru.hokan.looker.sniffer.strategies

import ru.hokan.looker.entities.ContentEntity

interface SniffingStrategy {
    fun sniffSource(source : String, proxy : String) : List<ContentEntity>
}