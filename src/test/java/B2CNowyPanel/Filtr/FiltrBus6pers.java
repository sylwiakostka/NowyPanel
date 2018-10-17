package B2CNowyPanel.Filtr;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class FiltrBus6pers {
    WebDriver driver;
    WebDriverWait waitDriver;
    String url;
    String logIn;
    String pass;
    String telNumb;
    String startAddress;
    String finallyAddress;
    String client;
    Wait<WebDriver> fluentWait;
    String buttonText;

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
        startAddress = "Ryżowa 2, Warszawa";
        finallyAddress = "Bema J. 1, Sulejówek";
        client = "Anna Wanna";
        buttonText = "Bus";


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
    public void makeOrderBus() throws InterruptedException {
        WebElement platnoscUKierowcy = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Płatność u kierowcy")));
        Thread.sleep(4000);
        platnoscUKierowcy.click();


        WebElement adresStartu = driver.findElement(By.id("address-from"));
        adresStartu.click();
        adresStartu.sendKeys(startAddress);
        WebElement ryzowaAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Ryżowa 2, Warszawa")));
        ryzowaAddress.click();

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//*[@id='address-to']")));
        builder.click();
        builder.sendKeys(finallyAddress);
        builder.build().perform();
        WebElement bemaAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Bema J. 1, Sulejówek")));
        bemaAddress.click();

        WebElement clientName = driver.findElement(By.id("client-name"));
        clientName.click();
        clientName.sendKeys(client);

        WebElement filtryButton = driver.findElement(By.cssSelector("#order-form > div > div.col-sm-7.col-main > div.row.order-form-section.order-form-options > div.col-md-4.col-filters > order-form-filters > a"));
        filtryButton.click();

        WebElement busCheckbox = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@uib-modal-transclude]//input[@ng-model='filters.bus.enabled']"));
            }
        });
        Thread.sleep(4000);
        waitDriver.until(ExpectedConditions.visibilityOf(busCheckbox));
        busCheckbox.click();
        Select iloscOsobLista = new Select(driver.findElement(By.xpath("//select")));
        iloscOsobLista.selectByVisibleText("6 os.");
        Assertions.assertEquals("6 os.", iloscOsobLista.getFirstSelectedOption().getText());

        WebElement zastosujZmianyButton = driver.findElement(By.cssSelector("body > div.modal.fade.ng-isolate-scope.in > div > div > div.modal-footer.ng-scope > div > div:nth-child(2) > button"));
        zastosujZmianyButton.click();
        String filtryButtonText = filtryButton.getText();
        Assertions.assertEquals("Filtry (1)", filtryButtonText);
        WebElement filtrBusButton = driver.findElement(By.xpath("//a[@class='btn btn-default ng-binding ng-scope']"));
        String filtrBusButtonText = filtrBusButton.getText();
        Assertions.assertEquals(buttonText, filtrBusButtonText);

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
