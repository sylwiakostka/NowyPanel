package B2CNowyPanel.Voucher;

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

public class VoucherForGuest {
    WebDriver driver;
    WebDriverWait waitDriver;
    String url;
    String logIn;
    String pass;
    String telNumb;
    String startAddress;
    String finallyAddress;
    Wait<WebDriver> fluentWait;
    String voucher;
    String client;

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
        startAddress = "Al.Jerozolimskie 124, Warszawa";
        finallyAddress = "Żurawia 1, Warszawa";
        voucher = "adec";
        client = "Marianna Jakaś";


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
    public void OrderWithVoucherEmployee() {
        WebElement voucherButton = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Voucher")));
        voucherButton.click();

        WebElement titleVoucher = driver.findElement(By.xpath("//h3"));
        String textTitle = titleVoucher.getText();
        Assertions.assertEquals("Voucher", textTitle);

        WebElement kodField = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@uib-modal-transclude]//input[@ng-model='c.code']")));
        kodField.sendKeys(voucher);
        WebElement sprawdzButton = driver.findElement(By.xpath("//a[text()='Sprawdź']"));
        sprawdzButton.click();

        WebElement acceptAlert = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(.,'Ten voucher')]")));
        Assertions.assertEquals("Ten voucher jest dostępny.", acceptAlert.getText());

        WebElement zastosujVoucherButton = driver.findElement(By.xpath("//button[@class ='btn btn-primary']"));
        zastosujVoucherButton.click();

        WebElement adresStartu = driver.findElement(By.id("address-from"));
        adresStartu.click();
        adresStartu.sendKeys(startAddress);
        WebElement dwZachAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Al. Jerozolimskie 124, Warszawa")));
        dwZachAddress.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='address-to']")));
        actions.click();
        actions.sendKeys(finallyAddress);
        actions.build().perform();
        WebElement zurawiaAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Żurawia 1, Warszawa")));
        zurawiaAddress.click();

        WebElement clientField = driver.findElement(By.id("client-name"));
        clientField.sendKeys(client);

        WebElement zapisz = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Zapisz")));
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

