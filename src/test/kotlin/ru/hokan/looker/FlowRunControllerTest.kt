package ru.hokan.looker

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.hokan.looker.controllers.FlowRunController

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [LookerApplication::class])
@WebMvcTest(FlowRunController::class)
class FlowRunControllerTest {

    @Autowired
    lateinit var mockMvc : MockMvc

    @Test
    fun `should run flow with name against source list with proxy`() {
        mockMvc.perform(MockMvcRequestBuilders.post(EXECUTE_FLOW_WITH_NAME_ENDPOINT)).andExpect(status().isOk)
    }

    companion object {
        const val EXECUTE_FLOW_WITH_NAME_ENDPOINT = "/executeFlow"
    }
}
