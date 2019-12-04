package ru.hokan.looker.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.hokan.looker.sniffer.flow.factories.FlowFactory
import java.util.*

@RestController
class FlowRunController {

    @Autowired
    lateinit var flowFactory: FlowFactory

    @RequestMapping("/executeFlow")
    fun executeFlow(@RequestParam flowName: String): ResponseEntity<String> {
        val flowByName = flowFactory.getFlowByName(flowName)
        if (flowByName == null) {
            return ResponseEntity("Flow with $flowName does not exists", HttpStatus.BAD_REQUEST)
        } else {
            flowByName.executeFlow()
            return ResponseEntity.of(Optional.of("cool"))
        }
    }

    @RequestMapping("/executeAllFlows")
    fun executeAllFlows(): ResponseEntity<String> {
        flowFactory.getFlowList().forEach { it.executeFlow() }
        return ResponseEntity.ok("Cool")
    }
}