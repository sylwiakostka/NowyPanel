package B2CNowyPanel.BasicOrder;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasicOrderAndNewAddress {
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
        startAddress = "Rolna 167, Warszawa";
        finallyAddress = "Jasna 5, Warszawa";
        client = "Ania Wolska";


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
    public void makeBasicOrder() {
        WebElement platnoscUKierowcy = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Płatność u kierowcy")));
        platnoscUKierowcy.click();

        WebElement adresStartu = driver.findElement(By.id("address-from"));
        adresStartu.click();
        adresStartu.sendKeys(startAddress);
        WebElement rolnaAdress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Rolna 167, Warszawa")));
        rolnaAdress.click();

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"address-to\"]")));
        builder.click();
        builder.sendKeys(finallyAddress);
        builder.build().perform();
        WebElement jasnaAddress = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Jasna 5, Warszawa")));
        jasnaAddress.click();


        WebElement clientName = driver.findElement(By.id("client-name"));
        clientName.click();
        clientName.sendKeys(client);

        WebElement zapisz = driver.findElement(By.partialLinkText("Zapisz"));
        zapisz.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }
}


