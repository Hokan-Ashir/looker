package ru.hokan.looker.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.hokan.looker.sniffer.flow.factories.FlowFactory
import java.util.*

@RestController
class FlowController {

    @Autowired
    lateinit var flowFactory: FlowFactory

    @RequestMapping("/flowList")
    fun getFlowList() : ResponseEntity<List<String>> {
        return ResponseEntity.of(Optional.of(flowFactory.getFlowList().map { it.getFlowName() }.toList()))
    }
}