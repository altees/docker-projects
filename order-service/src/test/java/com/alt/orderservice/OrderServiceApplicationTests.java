package com.alt.orderservice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderServiceApplicationTests {


    @BeforeAll
    public static void runBeforeAllMethod() {
        System.out.println("beforeAll method will only run once before all method like static blocks.. ");
    }

    @AfterAll
    public static void runAfterAllMethod() {
        System.out.println("AfterAll method will only run once after All method like static blocks.. ");
    }

    @BeforeEach
    public void runBeforeEach() {
        System.out.println("Run before each Test Method");
    }

    @AfterEach
    public void runAfterEach() {
        System.out.println("Run After each Test Method");
    }

    @Test
    @Order(1)
    public void testOrderCreation() {
        System.out.println("Creating order..");
    }

    @Test
    @Order(2)
    @DisplayName("Testing Order Update")
    public void testOrderUpdate() {
        System.out.println("Updating order..");
    }

    @Test
    @Order(3)
    public void testOrderDelete() {
        System.out.println("Deleting order..");
    }

    @Test
    @RepeatedTest(value = 3)
    public void testRepeatedly() {
        //will run 3 times
        System.out.println("Repeat test running");
    }


    @Test
    @Disabled
    public void testDisabledMethod() {
        System.out.println("Disabled Method Wont run..");
    }

}
