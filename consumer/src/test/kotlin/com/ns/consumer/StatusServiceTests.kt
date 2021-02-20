package com.ns.consumer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties

@SpringBootTest
class StatusServiceTests {

    @Autowired
    lateinit var underTest: StatusService

    @JvmField
    @RegisterExtension
    final val stubRunner = StubRunnerExtension()
        .downloadStub("com.ns", "producer", "0.0.1-SNAPSHOT", "stubs")
        .withPort(8080)
        .stubsMode(StubRunnerProperties.StubsMode.LOCAL)


    @Test
    fun getStatus() {
        val status = underTest.getStatus()
        assertEquals(status, "CREATED")
    }

    @Test
    fun getPactStatus() {
        val status = underTest.getPactStatus()
        assertEquals(status, "CREATED")
    }

}
