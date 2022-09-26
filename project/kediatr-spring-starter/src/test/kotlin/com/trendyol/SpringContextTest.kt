package com.trendyol

import com.trendyol.kediatr.CommandBus
import com.trendyol.kediatr.CommandBusImpl
import com.trendyol.kediatr.spring.KediatrConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertNotNull

@SpringBootTest(classes = [KediatrConfiguration::class])
class SpringContextTest {

    @Autowired
    lateinit var commandBus: CommandBus

    @Test
    fun contextLoads() {
        assertNotNull(commandBus)
        assert(commandBus is CommandBusImpl)
    }
}