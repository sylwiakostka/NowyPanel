package NowyPanelPageObject.config;

import NowyPanelPageObject.pages.HomePageLogIn;
import NowyPanelPageObject.pages.MakeOrderPage;
import NowyPanelPageObject.pages.NewOrderPage;
import NowyPanelPageObject.utilities.SendEmailWithAttachments;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;


public class TestConfig {

    private WebDriver driver;


    @BeforeTest
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


    @AfterMethod
    public void TakeScreenshotOfFailureAndTearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
                Date date = new Date();
                String dateOfTest = sdf.format(date);
                FileUtils.copyFile(src, new File("C:\\Users\\user\\IdeaProjects\\selenium\\src\\test\\java\\NowyPanelPageObject\\screens\\" + " " + dateOfTest + " " + result.getName() + ".png"));
                System.out.println("Successfully captured a screenshot" + " " + dateOfTest + " " + result.getName());
                SendEmailWithAttachments.sendEmailWithScreenOfError(dateOfTest + " " + result.getName(), dateOfTest + " " + result.getName());
                System.out.println("Successfully email sent");

            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        driver.quit();
    }

}



