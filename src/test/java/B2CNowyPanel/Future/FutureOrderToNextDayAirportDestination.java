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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class FutureOrderToNextDayAirportDestination {
    WebDriver driver;
    WebDriverWait waitDriver;
    String url;
    String logIn;
    String pass;
    String telNumb;
    String startAddress;
    String finallyAddress;
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
        driver.get(url);
        startAddress = "Żwirki i Wigury 1, Warszawa";
        finallyAddress = "Wiejska 2, Warszawa";
        client = "Kamila Wajda";

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
        WebElement lotniskoAdress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Żwirki i Wigury 1, Warszawa")));
        lotniskoAdress.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"address-to\"]")));
        actions.click();
        actions.sendKeys(finallyAddress);
        actions.build().perform();
        WebElement wiejskaAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Wiejska 2, Warszawa")));
        wiejskaAddress.click();

        WebElement dateField = driver.findElement(By.id("model-date"));
        dateField.clear();
        LocalDate date = LocalDate.now();
        LocalDate tomorrow = date.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String result = formatter.format(tomorrow);
        dateField.sendKeys(result);


        WebElement hour = driver.findElement(By.cssSelector("#order-form > div > div.col-sm-7.col-main > order-form-date-time > div > div.col-xs-4.col-md-3.col-time > table > tbody > tr:nth-child(3) > td.uib-decrement.hours > a > span"));
        hour.click();
        int i = 0;
        while (i < 5) {
            hour.click();
            i++;
        }

        WebElement clientName = driver.findElement(By.id("client-name"));
        clientName.click();
        clientName.sendKeys(client);

        WebElement liczbaTaksowekButton = driver.findElement(By.id("number-of-cars-dropdown"));
        liczbaTaksowekButton.click();
        WebElement dwieTaksowki = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("2")));
        dwieTaksowki.click();

        WebElement klasaTaxiButton = driver.findElement(By.id("car-class-dropdown"));
        klasaTaxiButton.click();
        WebElement popularna = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("popularna")));
        popularna.click();

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






