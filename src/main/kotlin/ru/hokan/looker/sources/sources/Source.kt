package ru.hokan.looker.sources.sources

interface Source {
    fun getBaseURL() : String
    fun getGeneratedURL() : String
}