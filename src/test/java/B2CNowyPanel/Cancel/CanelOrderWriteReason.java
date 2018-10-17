package B2CNowyPanel.Cancel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CanelOrderWriteReason {
    WebDriver driver;
    WebDriverWait waitDriver;
    String url;
    String logIn;
    String pass;
    String telNumb;
    String client;
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
        client = "Kazimierz Jasny";


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
    public void makeOrderToCancel() {
        WebElement platnoscUKierowcy = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Płatność u kierowcy")));
        platnoscUKierowcy.click();

        WebElement odrzucButton = driver.findElement(By.partialLinkText("Odrzuć"));
        odrzucButton.click();

        WebElement title = driver.findElement(By.xpath("//h3"));
        String titleText = title.getText();
        Assertions.assertEquals("Określ powód porzucenia zgłoszenia", titleText);
        WebElement wybierzButton = driver.findElement(By.id("reasons-dropdown"));
        wybierzButton.click();

        WebElement innyButton = driver.findElement(By.xpath("//a[text()='inny...']"));
        innyButton.click();
        WebElement opiszField = driver.findElement(By.id("reason"));
        opiszField.sendKeys("nie chce mi się");
        WebElement zapiszButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        zapiszButton.click();

        WebElement alert = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='alert alert-success']")));
        String alertText = alert.getText();
        Assertions.assertEquals("Obsługa zgłoszenie została zakończona. Możesz zamknąć okno przeglądarki.", alertText);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }
}
