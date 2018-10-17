package com.selenium;

import org.junit.jupiter.api.*;

public class JunitExamples { @Test
void shouldJunitWorks() {
    Assertions.assertTrue(true);
    System.out.println("test");
}

    @Test
    void shouldJunitWorksSecond() {
        Assertions.assertTrue(true);
        System.out.println("test2");
    }

    @BeforeEach
    public void setup() {
        System.out.println("setup");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tear down");
    }

    @BeforeAll
    static void init() {
        System.out.println("before all");
    }

    @AfterAll
    static void clean() {
        System.out.println("after all");
    }

}
