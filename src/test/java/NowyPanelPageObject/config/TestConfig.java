package NowyPanelPageObject.config;

import NowyPanelPageObject.pages.HomePageLogIn;
import NowyPanelPageObject.pages.MakeOrderPage;
import NowyPanelPageObject.pages.NewOrderPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;


public class TestConfig {

    private WebDriver driver;

    @BeforeEach
    public void setUpAndLogIn() throws InterruptedException {
        String baseURL = "https://taxi2.demo.eo.pl/login";
        driver = getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);

        new HomePageLogIn().verifyHomePage("Logowanie")
                .openNewOrderPage("sylwiacc", "123456789");

        new NewOrderPage().verifyNewOrderPage("Nowe zlecenie")
                .openMakeOrderPage("508264455");

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        Thread.sleep(5);

        new MakeOrderPage().verifyMakeOrderPage("Telefon do weryfikacji zgłoszenia i tel. kontaktowy do klienta");
    }

//    @AfterEach
//    public void tearDown (){
//        quit();
//    }
}
