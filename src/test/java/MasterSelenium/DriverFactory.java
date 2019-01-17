package MasterSelenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//to isolate each instance of WebDriver to make sure that there is  no cross contamination between tests.
// When our tests start running in parallel, we don't want different tests to start firing commands to the
// same browser window. Each instance of WebDriver is now safely locked away in its own thread.

public class DriverFactory {

    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>()); // synchronized list where we can store all our instances of WebDriverThread.
    private static ThreadLocal<WebDriverThread> driverThread;

    @BeforeSuite
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                webDriverThreadPool.add(webDriverThread); //add each instance of WebDriverThread that we create to this new synchronized list. This is so that we can keep track of all our threads.
                return webDriverThread;
            }
        };
    }

    public static WebDriver getDriver() throws Exception {
        return driverThread.get().getDriver();
    }

    @AfterMethod
    public static void clearCookies () throws Exception {
    getDriver().manage().deleteAllCookies();
    }


    // it iterates through our webDriverThreadPool, closing every threaded instance we are keeping track of.
    //  when our tests are finished, each WebDriver instance will be closed down cleanly, and without errors.
    @AfterSuite
    public static void closeDriverObjects(){
        for (WebDriverThread webDriverThread: webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }

}
