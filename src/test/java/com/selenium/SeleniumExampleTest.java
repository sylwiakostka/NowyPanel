package com.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumExampleTest {
    private ChromeDriver driver;

    @BeforeEach
    public void init() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com");
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

    @Test
    void shouldSearch() {
        WebElement searchInput = driver.findElementById("lst-ib");
        searchInput.sendKeys("abcd");
        searchInput.submit();

        WebElement results = driver.findElementById("resultStats");

        Assertions.assertTrue(results.isDisplayed());

    }

}