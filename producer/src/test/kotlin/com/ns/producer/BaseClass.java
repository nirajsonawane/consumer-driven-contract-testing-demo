package com.ns.producer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseClass {

    @Autowired
    private UserStatusController userStatusController;

    @MockBean
    private UserStatusService userStatusService;


    @BeforeEach
    public void setup() {
        Mockito.when(userStatusService.getUserStatus(1)).thenReturn(new UserStatus(1, "CREATED"));
        RestAssuredMockMvc.standaloneSetup(userStatusController);
    }

}
