package com.logistics;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class TrackingApplicationTests {

    @Autowired
    private TrackingApplication trackingApplication;

    @Test
    void contextLoads() {
        // to ensure that controller is getting created inside the application context
        assertNotNull(trackingApplication);
    }

}
