package B2CNowyPanel.Future;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FutureOrder20minDestination {

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

    @BeforeEach
    public void initAndLogIn() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://taxi2.demo.eo.pl/login";
        logIn = "sylwia";
        pass = "123456789";
        telNumb = "508264455";
        waitDriver = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
        driver.get(url);
        startAddress = "Żwirki i Wigury 3, Warszawa";
        finallyAddress = "Jerozolimskie 54, Warszawa";
        client = "Ewa Morska";
        commnent = "szybciutko";


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
    public void makeFutureOrder() {
        WebElement platnoscUKierowcy = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Płatność u kierowcy")));
        platnoscUKierowcy.click();

        WebElement adresStartu = driver.findElement(By.id("address-from"));
        adresStartu.click();
        adresStartu.sendKeys(startAddress);
        WebElement lotniskoAdress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Żwirki i Wigury 3, Warszawa")));
        lotniskoAdress.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"address-to\"]")));
        actions.click();
        actions.sendKeys(finallyAddress);
        actions.build().perform();
        WebElement dwCentralnyAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Al. Jerozolimskie 54, Warszawa")));
        dwCentralnyAddress.click();

        WebElement minute = driver.findElement(By.cssSelector("#order-form > div > div.col-sm-7.col-main > order-form-date-time > div > div.col-xs-4.col-md-3.col-time > table > tbody > tr:nth-child(1) > td.uib-increment.minutes > a > span"));
        int i = 0;
        while (i < 21) {
            minute.click();
            i++;
        }
        WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-warning']"));
        Assertions.assertTrue(alert.isDisplayed());
        String alertText = alert.getText();
        Assertions.assertEquals("Wskazana data/godzina spowoduje utworzenie zlecenia terminowego.\n" +
                "Wydaj zlecenie natychmiast", alertText);

        WebElement clientName = driver.findElement(By.id("client-name"));
        clientName.click();
        clientName.sendKeys(client);

        WebElement commentField = driver.findElement(By.id("model-comment"));
        commentField.sendKeys(commnent);

        WebElement zapisz = driver.findElement(By.partialLinkText("Zapisz"));
        zapisz.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
