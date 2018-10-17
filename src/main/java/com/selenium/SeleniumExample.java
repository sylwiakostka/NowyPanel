package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        //googleSearch(driver);
        links(driver);

        driver.get("http://www.bbc.com/news");
        List<WebElement> links = driver.findElementsByTagName("a");
        for (WebElement element : links) {

            //pobiernie tresci
            element.getText();

            //pobieranie adresu url
            element.getAttribute("href");

            System.out.println(element.getAttribute("href"));
            System.out.println(element.getText());

        }
    }

    public static void googleSearch(ChromeDriver driver) {
        driver.get("http://google.com");

//szukanie slowa w wyszukiwarce
        WebElement element = driver.findElementById("lst-ib");
        element.sendKeys("abcd");
        element.submit();
    }

    public static void links(ChromeDriver driver) {

    }
}


