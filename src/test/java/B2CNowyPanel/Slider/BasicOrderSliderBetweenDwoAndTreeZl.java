package B2CNowyPanel.Slider;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;

public class BasicOrderSliderBetweenDwoAndTreeZl {
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
        startAddress = "Prosta 2, Warszawa";
        finallyAddress = "Jerozolimskie 54, Warszawa";
        client = "Hania Górka";
        commnent = "walizka i 2 osoby towarzyszące";


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
    public void makeBasicOrdersSlider() {
        WebElement platnoscUKierowcy = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Płatność u kierowcy")));
        platnoscUKierowcy.click();


        WebElement adresStartu = driver.findElement(By.id("address-from"));
        adresStartu.click();
        adresStartu.sendKeys(startAddress);
        WebElement lotniskoAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Prosta 2, Warszawa")));
        lotniskoAddress.click();

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"address-to\"]")));
        builder.click();
        builder.sendKeys(finallyAddress);
        builder.build().perform();
        WebElement dworzecCentralnyoAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Al. Jerozolimskie 54, Warszawa")));
        dworzecCentralnyoAddress.click();

        WebElement clientName = driver.findElement(By.id("client-name"));
        clientName.click();
        clientName.sendKeys(client);

        WebElement sliderA = driver.findElement(By.xpath("//*[@id=\"tariffs\"]/div[1]/div[1]/i"));
        WebElement sliderB = driver.findElement(By.xpath("//*[@id=\"tariffs\"]/div[1]/div[2]/i"));

        Actions dragAndDropeA = builder.dragAndDropBy(sliderA, 180, 0);
        dragAndDropeA.build().perform();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
        Actions dragAndDropeB = builder.dragAndDropBy(sliderB,-350,0);
        dragAndDropeB.build().perform();

        WebElement valueA = driver.findElement(By.xpath("//*[@id=\"order-form\"]/div/div[1]/order-form-tariff/div/div[1]/div"));
        WebElement valueB = driver.findElement(By.xpath("//*[@id=\"order-form\"]/div/div[1]/order-form-tariff/div/div[3]/div"));
        String textA = valueA.getText();
        String textB = valueB.getText();
        Assertions.assertEquals("2 zł", textA);
        Assertions.assertEquals("3 zł", textB);


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
