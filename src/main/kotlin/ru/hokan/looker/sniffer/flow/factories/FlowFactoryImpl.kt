package ru.hokan.looker.sniffer.flow.factories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.hokan.looker.sniffer.flow.Flow

@Component
class FlowFactoryImpl : FlowFactory {
    @Value("\${looker.active.flows}")
    var flowNames : String? = null

    @Autowired
    lateinit var flows : List<Flow>

    override fun getFlowByName(flowName : String): Flow? {
        return flows.find { it.getFlowName() == flowName }
    }

    override fun getFlowList(): List<Flow> {
        val flowNames = flowNames!!.split(",")
        return flows.filter { !flowNames.contains(it.getFlowName()) }
    }
}