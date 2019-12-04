package ru.hokan.looker.sniffer.flow.factories

import ru.hokan.looker.sniffer.flow.Flow

interface FlowFactory {
    fun getFlowList() : List<Flow>
    fun getFlowByName(flowName : String) : Flow?
}