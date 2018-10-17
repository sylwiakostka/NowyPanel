package B2CNowyPanel.BasicOrder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasicOrderLuxuryComment {

    WebDriver driver;
    WebDriverWait waitDriver;
    String url;
    String logIn;
    String pass;
    String telNumb;
    String startAddress;
    String finallyAddress;
    String client;
    String commnent;
    Wait<WebDriver> fluentWait;

    @BeforeEach
    public void initAndLogIn() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://taxi2.demo.eo.pl/login";
        logIn = "sylwia";
        pass = "123456789";
        telNumb = "508264455";
        waitDriver = new WebDriverWait(driver, 15);
        fluentWait = new FluentWait<WebDriver>(driver).
                withTimeout(10, TimeUnit.SECONDS).
                pollingEvery(2, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
        driver.get(url);
        startAddress = "Wernyhory 20, Warszawa";
        finallyAddress = "Jerozolimskie 2, Warszawa";
        client = "Kazimierz Jasny";
        commnent = "panicz";


        WebElement nazwaUzytkownika = driver.findElement(By.id("login-username"));
        nazwaUzytkownika.sendKeys(logIn);
        WebElement haslo = driver.findElement(By.id("login-password"));
        haslo.sendKeys(pass);
        WebElement buttonZaloguj = driver.findElement(By.name("login-button"));
        buttonZaloguj.click();

        WebElement fieldNumerTelefonu = driver.findElement(By.id("phone"));
        fieldNumerTelefonu.sendKeys(telNumb);
        WebElement buttonSubmin = driver.findElement(By.xpath("/html/body/main/div/form/div/button"));
        buttonSubmin.click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    @Test
    public void makeOrderLuxury() {
        WebElement platnoscUKierowcy = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Płatność u kierowcy")));
        platnoscUKierowcy.click();

        WebElement adresStartu = driver.findElement(By.id("address-from"));
        adresStartu.click();
        adresStartu.sendKeys(startAddress);
        WebElement wenyhoryAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Wernyhory 20, Warszawa")));
        wenyhoryAddress.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"address-to\"]")));
        actions.click();
        actions.sendKeys(finallyAddress);
        actions.build().perform();
        WebElement FinallyAddressJer = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Al. Jerozolimskie 2, Warszawa")));
        FinallyAddressJer.click();

        WebElement clientName = driver.findElement(By.id("client-name"));
        clientName.click();
        clientName.sendKeys(client);

        WebElement klasaTaxiButton = driver.findElement(By.id("car-class-dropdown"));
        klasaTaxiButton.click();
        WebElement luksusowa = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("luksusowa")));
        luksusowa.click();

        WebElement commentField = driver.findElement(By.id("model-comment"));
        commentField.sendKeys(commnent);

        WebElement zapisz = driver.findElement(By.partialLinkText("Zapisz"));
        zapisz.click();

        WebElement alertSucces = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > main > order-view > div > div.ng-scope > p")));
        String textOnalertSucces = alertSucces.getText();
        Assertions.assertEquals("Obsługa zgłoszenie została zakończona. Możesz zamknąć okno przeglądarki.", textOnalertSucces);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }
}

