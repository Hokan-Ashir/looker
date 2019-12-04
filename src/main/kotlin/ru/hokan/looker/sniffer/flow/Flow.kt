package ru.hokan.looker.sniffer.flow

interface Flow {
    fun executeFlow()
    fun getFlowName() : String
}