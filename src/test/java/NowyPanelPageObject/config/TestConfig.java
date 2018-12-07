package NowyPanelPageObject.config;

import NowyPanelPageObject.pages.HomePageLogIn;
import NowyPanelPageObject.pages.MakeOrderPage;
import NowyPanelPageObject.pages.NewOrderPage;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;


public class TestConfig {

    private WebDriver driver;


    @Before
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
}

//    @AfterEach
//    public void TakeScreenIfFailureAndTearDown (){
//        public void screenShot(ITestResult result){
//            //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
//            if(ITestResult.FAILURE==result.getStatus()){
//                try{
//                    // To create reference of TakesScreenshot
//                    TakesScreenshot screenshot=(TakesScreenshot)driver;
//                    // Call method to capture screenshot
//                    File src=screenshot.getScreenshotAs(OutputType.FILE);
//                    // Copy files to specific location
//                    // result.getName() will return name of test case so that screenshot name will be same as test case name
//                    FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
//                    System.out.println("Successfully captured a screenshot");
//                }catch (Exception e){
//                    System.out.println("Exception while taking screenshot "+e.getMessage());
//                }
//            }
//            driver.quit();
//        }



